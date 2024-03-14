package dtos.requests;

import org.junit.jupiter.api.Test;
import services.DiaryServices;
import services.DiaryServicesImplement;

import static org.junit.jupiter.api.Assertions.*;

class RegisterRequestTest {
    private DiaryServices diaryServices = new DiaryServicesImplement();

    @Test
    public void registerUser(){
        RegisterRequest registerRequest = new RegisterRequest("username", "password");
        registerRequest.setUsername("username");
        registerRequest.setPassword("password");
        diaryServices.register(registerRequest);
        assertEquals(1, diaryServices.getNumberOfUsers());

    }

}