package data.respository;

import data.model.Diary;
import data.model.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntryRepositoryImplementTest {
    private EntryRepository repository;
    @BeforeEach
    public void initializer(){
        repository = new EntryRepositoryImplement();
    }
    @Test
    public void saveTest(){
        Entry entry = new Entry(1,"title", "body");
        repository.save(entry);

        assertEquals(1, repository.count());

    }
    @Test
    public void saveTwoTest(){
        Entry entry = new Entry(1,"title", "body");
        Entry entry1 = new Entry(2,"title", "body");
        repository.save(entry);
        repository.save(entry1);
        assertEquals(2, repository.count());

    }
    @Test
    public void findUserByUsernameTest(){
        Entry entry = new Entry(1,"title", "body");
        repository.save(entry);
        Entry foundDiary = repository.findById(1);
        assertEquals(1, foundDiary.getId());
        assertEquals(1, repository.count());
    }

}