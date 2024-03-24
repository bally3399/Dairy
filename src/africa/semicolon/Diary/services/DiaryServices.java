package africa.semicolon.Diary.services;

import africa.semicolon.Diary.data.model.Diary;
import africa.semicolon.Diary.dtos.requests.CreateEntryRequest;
import africa.semicolon.Diary.dtos.requests.LoginRequest;
import africa.semicolon.Diary.dtos.requests.RegisterRequest;

public interface DiaryServices {
    void register(RegisterRequest registerRequest);
    void login(LoginRequest loginRequest);
    Diary findUserBy(String username);
    void createEntryWith(CreateEntryRequest createEntryRequest);
    void logout(String username);
    int getNumberOfUsers();
}