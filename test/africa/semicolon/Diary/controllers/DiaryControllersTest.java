package africa.semicolon.Diary.controllers;

import africa.semicolon.Diary.dtos.requests.LoginRequest;
import africa.semicolon.Diary.dtos.requests.RegisterRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryControllersTest {
    private DiaryControllers controllers = new DiaryControllers();

    @Test
    public void registerUser(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("1234");
        assertEquals("register successful", controllers.register(registerRequest));
    }

    @Test
    public void registerUserWithSameName(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("1234");
        controllers.register(registerRequest);

        RegisterRequest registerRequest2 = new RegisterRequest();
        registerRequest2.setUsername("username");
        registerRequest2.setPassword("1234");

        assertEquals("username already exist", controllers.register(registerRequest2));
    }

    @Test
    public void loginTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        controllers.register(registerRequest);

        LoginRequest login = new LoginRequest();
        login.setUsername("username");
        login.setPassword("password");
        assertEquals("Login successful", controllers.login(login));
    }
    @Test
    public void loginWithIncorrectUserNameTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("user");
        registerRequest.setPassword("password");
        controllers.register(registerRequest);

        LoginRequest login = new LoginRequest();
        login.setUsername("user");
        login.setPassword("pass");
        assertEquals("Incorrect password", controllers.login(login));
    }
    @Test
    public void logoutTest(){
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        controllers.register(registerRequest);

        LoginRequest login = new LoginRequest();
        login.setUsername("username");
        login.setPassword("password");
        assertEquals("Login successful", controllers.login(login));

    }

}
