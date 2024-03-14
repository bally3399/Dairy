package services;

import data.model.Diary;
import data.repository.DiaryRepository;
import data.repository.DiaryRepositoryImplement;
import dtos.requests.RegisterRequest;

public class DiaryServicesImplement implements DiaryServices{
    private DiaryRepository diaryRepository = new DiaryRepositoryImplement();
    private int count;
    @Override
    public void register(RegisterRequest registerRequest){
        count++;
        Diary newDiary = new Diary();
        newDiary.setUsername(registerRequest.getUsername());
        newDiary.setPassword(registerRequest.getPassword());
        diaryRepository.save(newDiary);

    }

    @Override
    public int getNumberOfUsers() {
        return count;
    }
}
