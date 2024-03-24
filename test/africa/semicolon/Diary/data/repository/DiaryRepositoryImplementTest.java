//package africa.semicolon.Diary.data.repository;
//
//import africa.semicolon.Diary.data.model.Diary;
//import lombok.AllArgsConstructor;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@AllArgsConstructor
//public class DiaryRepositoryImplementTest {
//    private final DiaryRepository repository;
//    @Test
//    public void saveTest(){
//        Diary diary = new Diary();
//        repository.save(diary);
//        assertEquals(1l, repository.count());
//    }
//    @Test
//    public void saveTwoTest(){
//        Diary diary = new Diary();
//        Diary diary1 = new Diary();
//        repository.save(diary);
//        repository.save(diary1);
//        assertEquals(2l, repository.count());
//
//    }
////    @Test
////    public void findUserByUsernameTest(){
////        Diary diary = new Diary();
////        repository.save(diary);
////        Diary foundDiary = repository.findById();
////        assertEquals("username", foundDiary.getUsername());
////        assertEquals(1l, repository.count());
////    }
////    @Test
////    public void findTwoUserByUsernameTest(){
////        Diary diary = new Diary();
////        repository.save(diary);
////
////        Diary diary1 = new Diary();
////        repository.save(diary1);
////
////        Diary foundDiary = repository.findById("username");
////        Diary foundDiary1 = repository.findById("username1");
////
////        assertEquals("username", foundDiary.getUsername());
////        assertEquals("username1", foundDiary1.getUsername());
////    }
//    @Test
//    public void findUserByUsername_deleteWithUsername_diaryIsEmptyTest(){
//        Diary diary = new Diary();
//        repository.save(diary);
//        repository.delete(diary);
//        assertEquals(0, repository.count());
//    }
//    @Test
//    public void findTwoUserByUsername_deleteOneWithUsername_diaryIsNotEmptyTest(){
//        Diary diary = new Diary();
//        repository.save(diary);
//
//        Diary diary1 = new Diary();
//        repository.save(diary1);
//
//        repository.delete(diary);
//
//        assertEquals(1l, repository.count());
//    }
//    @Test
//    public void findAllTest(){
//        Diary diary = new Diary();
//        repository.save(diary);
//
//        Diary diary1 = new Diary();
//        repository.save(diary1);
//
//        repository.findAll();
//        assertEquals(2l, repository.count());
//    }
//    @Test
//    public void deleteWithDiaryTest(){
//        Diary diary = new Diary();
//        repository.save(diary);
//        assertEquals(1l, repository.count());
//
//        repository.delete(diary);
//        assertEquals(0l, repository.count());
//    }
//    @Test
//    public void saveTwoDiaries_deleteOne_diaryIsNotEmpty(){
//        Diary diary = new Diary();
//        repository.save(diary);
//
//        Diary diary1 = new Diary();
//        repository.save(diary1);
//        assertEquals(2l, repository.count());
//
//        repository.delete(diary);
//        assertEquals(1l, repository.count());
//    }
//    @Test
//    public void saveTwoDiaries_deleteTWo_diaryIsNotEmpty(){
//        Diary diary = new Diary();
//        repository.save(diary);
//
//        Diary diary1 = new Diary();
//        repository.save(diary1);
//
//        assertEquals(2l, repository.count());
//
//        repository.delete(diary);
//        repository.delete(diary1);
//        assertEquals(0l, repository.count());
//    }
//
//
//}