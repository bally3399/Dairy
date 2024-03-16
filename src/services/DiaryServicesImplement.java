package services;

import data.model.Diary;
import data.repository.DiaryRepository;
import data.repository.DiaryRepositoryImplement;
import dtos.requests.RegisterRequest;
import services.exception.UsernameException;

public class DiaryServicesImplement implements DiaryServices{
    private DiaryRepository diaryRepository = new DiaryRepositoryImplement();
    private int count;
    @Override
    public void register(RegisterRequest registerRequest){
        validateUsername(registerRequest.getUsername());
        count++;
        Diary newDiary = new Diary();
        newDiary.setUsername(registerRequest.getUsername());
        newDiary.setPassword(registerRequest.getPassword());
        diaryRepository.save(newDiary);
    }


    private void validateUsername(String username) {
        var diary = diaryRepository.findById(username);
        if(diary != null) throw new UsernameException(String.format("%s username already exist", username));
    }

    @Override
    public int getNumberOfUsers() {
        return count;
    }
}
