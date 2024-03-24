package africa.semicolon.Diary.services;

import africa.semicolon.Diary.data.repository.DiaryRepository;
import africa.semicolon.Diary.dtos.requests.CreateEntryRequest;
import africa.semicolon.Diary.dtos.requests.LoginRequest;
import africa.semicolon.Diary.dtos.requests.RegisterRequest;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import africa.semicolon.Diary.exception.IncorrectPassword;
import africa.semicolon.Diary.exception.UsernameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DiaryServicesImplementTest {
    @Autowired
    private DiaryRepository diaryRepository;
    @Autowired
    private DiaryServices diaryServices;
    @Autowired
    private EntryServices entryServices;

    @BeforeEach
    public void setDiaryServices(){
        diaryRepository.deleteAll();
    }
    @Test
    public void registerUserTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryServices.register(registerRequest);
//        assertEquals(1, diaryServices.getNumberOfUsers());

    }
    @Test
    public void registerTwiceWithSameDetails_ThrowUserExistException(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryServices.register(registerRequest);

        assertThrows(UsernameException.class,()-> diaryServices.register(registerRequest));
    }

    @Test
    public void registerUser_LoginTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryServices.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryServices.login(loginRequest);
        assertEquals(1, diaryServices.getNumberOfUsers());
    }

    @Test
    public void registerUserTest1(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryServices.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryServices.login(loginRequest);
        assertFalse(diaryServices.findUserBy("username").isLocked());


    }
    @Test
    public void loginWithWrongUsernameTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryServices.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("user name");
        loginRequest.setPassword("password");
        assertThrows(IncorrectPassword.class, ()->diaryServices.login(loginRequest));

    }

    @Test
    public void register_loginWithCorrectPasswordAndLogoutWithCorrectPasswordTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryServices.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryServices.login(loginRequest);

        diaryServices.logout("username");
        assertTrue(diaryServices.findUserBy("username").isLocked());

    }
    @Test
    public void register_loginWithValidInput_logoutWithInvalidInput_throwIncorrectPassword(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryServices.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryServices.login(loginRequest);

        assertThrows(IncorrectPassword.class,()-> diaryServices.logout("user name"));
    }

    @Test
    public void createEntry(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryServices.register(registerRequest);

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("username");
        loginRequest.setPassword("password");
        diaryServices.login(loginRequest);

        CreateEntryRequest createEntryRequest = new CreateEntryRequest();
        createEntryRequest.setTitle("title");
        createEntryRequest.setBody("body");
        createEntryRequest.setAuthor("username");
        diaryServices.createEntryWith(createEntryRequest);
        assertEquals(1, entryServices.getEntriesFor("username").size());

    }
}