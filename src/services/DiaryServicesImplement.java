package services;

import data.model.Diary;
import data.model.Entry;
import data.repository.DiaryRepository;
import data.repository.DiaryRepositoryImplement;
import data.repository.EntryRepository;
import data.repository.EntryRepositoryImplement;
import dtos.requests.CreateEntryRequest;
import dtos.requests.RegisterRequest;
import dtos.requests.LoginRequest;
import exception.DiaryNotFound;
import exception.IncorrectPassword;
import exception.UsernameException;

public class DiaryServicesImplement implements DiaryServices{
    private  DiaryRepository diaryRepository = new DiaryRepositoryImplement();
    private EntryRepository entryRepository = new EntryRepositoryImplement();
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
    public void login(LoginRequest login){
        String username = login.getUsername();
        Diary diary = diaryRepository.findById(username);
        if(diary == null) throw new DiaryNotFound("Diary not found");
        if(!login.getPassword().equals(diary.getPassword())) throw new IncorrectPassword("Incorrect password");
        diary.setLock(false);
    }
    public void logout(String username) {
        Diary diary = diaryRepository.findById(username);
        if (diary == null || !diary.getUsername().equals(username)) {
            throw new IncorrectPassword("Username is not valid");
        }
        diary.setLock(true);
    }



    public Diary findUserBy(String username){
        return  diaryRepository.findById(username);
    }

    @Override
    public void createEntryWith(CreateEntryRequest createEntryRequest) {
        Entry entry = new Entry();
        entry.setTitle(createEntryRequest.getTitle());
        entry.setBody(createEntryRequest.getBody());
        entry.setAuthor(createEntryRequest.getAuthor());
        entryRepository.save(entry);

    }


}
