package services;

import dtos.requests.CreateEntryRequest;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;
import org.junit.jupiter.api.Test;

import exception.IncorrectPassword;
import exception.UsernameException;

import static org.junit.jupiter.api.Assertions.*;

class DiaryServicesImplementTest {
    private DiaryServices diaryServices = new DiaryServicesImplement();
    private EntryServices entryServices = new EntryServicesImpl();

    @Test
    public void registerUserTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryServices.register(registerRequest);
        assertEquals(1, diaryServices.getNumberOfUsers());

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