package africa.semicolon.Diary.services;

import africa.semicolon.Diary.data.model.Diary;
import africa.semicolon.Diary.data.repository.DiaryRepository;
import africa.semicolon.Diary.dtos.requests.CreateEntryRequest;
import africa.semicolon.Diary.dtos.requests.RegisterRequest;
import africa.semicolon.Diary.dtos.requests.LoginRequest;
import africa.semicolon.Diary.exception.DiaryAppExceptions;
import africa.semicolon.Diary.exception.IncorrectPassword;
import africa.semicolon.Diary.exception.UsernameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryServicesImplement implements DiaryServices{

    @Autowired
    private  DiaryRepository diaryRepository;
    private EntryServices entryService;

    @Override
    public void register(RegisterRequest registerRequest) {
        Diary diary = diaryRepository.findDiaryByUsername(registerRequest.getUsername());
        if (diary == null){
            Diary newDiary = new Diary();
            newDiary.setUsername(registerRequest.getUsername());
            newDiary.setPassword(registerRequest.getPassword());
            diaryRepository.save(newDiary);
            return;
        }
        throw new UsernameException(String.format("%s username already exists", registerRequest.getUsername()));
    }

    @Override
    public void login(LoginRequest login){
        String username = login.getUsername();
        Diary diary = diaryRepository.findDiaryByUsername(username);
        if(diary == null) throw new DiaryAppExceptions("Diary not found");
        diary.setLocked(false);
    }
    @Override
    public void logout(String username) {
        Diary diary = diaryRepository.findDiaryByUsername(username);
        if (diary == null) throw new IncorrectPassword("Username is not valid");
        diary.setLocked(true);
    }

    @Override
    public int getNumberOfUsers() {
        return 0;
    }
//    @Override
//    public void updateEntry(String title, String body) {
//
//    }

//    @Override
//    public void updateEntry(String title, String body) {
//        Entry entry = entryRepository.findByTitle("title");
//        if (entry != null && entry.getBody().equals(body)) {
//            entry.setBody(body);
//            entryRepository.save(entry);
//            System.out.println("Entry updated successfully");
//        } else {
//            throw new EntryNotFoundException("Entry not found");
//        }
//    }



    @Override
    public Diary findUserBy(String username){
        return diaryRepository.findDiaryByUsername(username);
    }




    @Override
    public void createEntryWith(CreateEntryRequest createEntryRequest) {
        CreateEntryRequest entry = new CreateEntryRequest();
        entry.setTitle(createEntryRequest.getTitle());
        entry.setBody(createEntryRequest.getBody());
        entry.setAuthor(createEntryRequest.getAuthor());
        entryService.addEntry(entry);
   }

}
