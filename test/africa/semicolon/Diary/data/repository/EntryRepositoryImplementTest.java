package africa.semicolon.Diary.data.repository;

import africa.semicolon.Diary.data.model.Entry;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@AllArgsConstructor
public class EntryRepositoryImplementTest {
    private final EntryRepository repository;


    @Test
    public void saveTest() {
        Entry entry = new Entry();
        repository.save(entry);

        assertEquals(1, repository.count());

    }

    @Test
    public void saveTwoTest() {
        Entry entry = new Entry();
        Entry entry1 = new Entry();
        repository.save(entry);
        repository.save(entry1);
        assertEquals(1, repository.count());

    }

//    @Test
//    public void findUserByUsernameTest() {
//        Entry entry = new Entry();
//        repository.save(entry);
//        Entry foundDiary = repository.findById(1);
//        assertEquals(1, foundDiary.getId());
//        assertEquals(1, repository.count());
//    }

//    @Test
//    public void findTwoUserByUsernameTest() {
//        Entry entry = new Entry();
//        repository.save(entry);
//
//        Entry entry1 = new Entry();
//        repository.save(entry1);
//
//        Entry foundEntry = repository.findById(1);
//        Entry foundEntry1 = repository.findById(2);
//
//        assertEquals(1, foundEntry.getId());
//        assertEquals(2, foundEntry1.getId());
//    }

//    @Test
//    public void findTwoUserByUsername_deleteOneWithUsername_EntryIsNotEmptyTest() {
//        Entry entry = new Entry();
//        repository.save(entry);
//
//        Entry entry1 = new Entry();
//        repository.save(entry1);
//        Entry foundEntry = repository.findById(1);
//        Entry foundEntry1 = repository.findById(2);
//
//        repository.delete(foundEntry);
//
//        assertEquals(2, foundEntry1.getId());
//    }

    @Test
    public void deleteWithEntryTest() {
        Entry entry = new Entry();
        repository.save(entry);
        assertEquals(1, repository.count());

        repository.delete(entry);
        assertEquals(0, repository.count());
    }

    @Test
    public void saveTwoEntries_deleteOne_entryIsNotEmpty() {
        Entry entry = new Entry();
        repository.save(entry);

        Entry entry1 = new Entry();
        repository.save(entry1);
        assertEquals(2, repository.count());

        repository.delete(entry);
        assertEquals(1, repository.count());
    }

    @Test
    public void saveTwoDiaries_deleteTwo_diaryIsNotEmpty() {
        Entry entry = new Entry();
        repository.save(entry);

        Entry entry1 = new Entry();
        repository.save(entry1);

        assertEquals(2, repository.count());

        repository.delete(entry);
        repository.delete(entry1);
        assertEquals(0, repository.count());
    }
    @Test
    public void saveTwoDiary_findAll(){
        Entry entry = new Entry();
        repository.save(entry);

        Entry entry1 = new Entry();
        repository.save(entry1);
        repository.findAll();

        assertEquals(2, repository.count());
    }

//    @Test
//    public void update(){
//        Entry entry = new Entry();
//        repository.save(entry);
//
//        Entry updatedEntry = repository.findById(1);
//        updatedEntry.setTitle("updatedTitle");
//        updatedEntry.setBody("updatedBody");
//        repository.save(updatedEntry);
//
//        assertEquals(1, updatedEntry.getId());
//        assertEquals("updatedTitle", updatedEntry.getTitle());
//        assertEquals("updatedBody", updatedEntry.getBody());
//    }

}