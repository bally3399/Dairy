package services;

import data.model.Diary;
import dtos.requests.CreateEntryRequest;
import dtos.requests.LoginRequest;
import dtos.requests.RegisterRequest;

public interface DiaryServices {
    void register(RegisterRequest registerRequest);

    int getNumberOfUsers();

    void login(LoginRequest loginRequest);

    Diary findUserBy(String username);

    void createEntryWith(CreateEntryRequest createEntryRequest);
    void logout(String username);

    void updateEntry(String title, String body);
}