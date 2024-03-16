package services;

import dtos.requests.RegisterRequest;
import org.junit.jupiter.api.Test;

import services.exception.UsernameException;

import static org.junit.jupiter.api.Assertions.*;

class DiaryServicesImplementTest {
    private DiaryServices diaryServices = new DiaryServicesImplement();

    @Test
    public void registerUser(){
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

}