package services;

import data.model.Diary;
import dtos.requests.RegisterRequest;

public interface DiaryServices {
    void register(RegisterRequest registerRequest);

    int getNumberOfUsers();
}