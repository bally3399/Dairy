package data.respository;

import data.model.Diary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryRepositoryImplementTest {
    private DiaryRepository repository;
    @BeforeEach
    public void initializer(){
        repository = new DiaryRepositoryImplement();
    }
    @Test
    public void saveTest(){
        Diary diary = new Diary("username", "1234");
        repository.save(diary);
        assertEquals(1, repository.count());
    }
    @Test
    public void saveTwoTest(){
        Diary diary = new Diary("username", "1234");
        Diary diary1 = new Diary("username1", "1233");
        repository.save(diary);
        repository.save(diary1);
        assertEquals(2, repository.count());

    }
    @Test
    public void findUserByUsernameTest(){
        Diary diary = new Diary("username", "1234");
        repository.save(diary);
        Diary foundDiary = repository.findById("username");
        assertEquals("username", foundDiary.getUsername());
        assertEquals(1, repository.count());
    }
    @Test
    public void findTwoUserByUsernameTest(){
        Diary diary = new Diary("username", "1234");
        repository.save(diary);

        Diary diary1 = new Diary("username1", "1234");
        repository.save(diary1);

        Diary foundDiary = repository.findById("username");
        Diary foundDiary1 = repository.findById("username1");

        assertEquals("username", foundDiary.getUsername());
        assertEquals("username1", foundDiary1.getUsername());

        assertEquals(2, repository.count());
    }
    @Test
    public void findUserByUsername_deleteWithUsername_diary_isEmptyTest(){
        Diary diary = new Diary("username", "1234");
        repository.save(diary);
        Diary foundDiary = repository.findById("username");
        repository.delete("username");
        assertEquals("username", foundDiary.getUsername());
        assertEquals(0, repository.count());
    }
    @Test
    public void findTwoUserByUsername_deleteOneWithUsername_diaryIsNotEmptyTest(){
        Diary diary = new Diary("username", "1234");
        repository.save(diary);

        Diary diary1 = new Diary("username1", "1234");
        repository.save(diary1);

        Diary foundDiary = repository.findById("username");
        Diary foundDiary1 = repository.findById("username1");

        repository.delete("username");

        assertEquals("username", foundDiary.getUsername());
        assertEquals("username1", foundDiary1.getUsername());

        assertEquals(1, repository.count());
    }
    @Test
    public void findAllTest(){
        Diary diary = new Diary("username", "1234");
        repository.save(diary);

        Diary diary1 = new Diary("username1", "1234");
        repository.save(diary1);

        repository.findAll();
        assertEquals(2, repository.count());
    }
    @Test
    public void deleteWithDiaryTest(){
        Diary diary = new Diary("username", "1234");
        repository.save(diary);
        assertEquals(1, repository.count());

        repository.delete(diary);
        assertEquals(0, repository.count());
    }
    @Test
    public void saveTwoDiaries_deleteOne_diaryIsNotEmpty(){
        Diary diary = new Diary("username", "1234");
        repository.save(diary);

        Diary diary1 = new Diary("username1", "1234");
        repository.save(diary1);
        assertEquals(2, repository.count());

        repository.delete(diary);
        assertEquals(1, repository.count());
    }
    @Test
    public void saveTwoDiaries_deleteTWo_diaryIsNotEmpty(){
        Diary diary = new Diary("username", "1234");
        repository.save(diary);

        Diary diary1 = new Diary("username1", "1234");
        repository.save(diary1);
        assertEquals(2, repository.count());

        repository.delete(diary);
        repository.delete(diary1);
        assertEquals(0, repository.count());
    }


}