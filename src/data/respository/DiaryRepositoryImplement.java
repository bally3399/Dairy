package data.respository;

import data.model.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImplement implements DiaryRepository{
    private List<Diary> diaries = new ArrayList<>();


    @Override
    public Diary save(Diary diary) {
        diaries.add(diary);
        return diary;
    }

    @Override
    public List<Diary> findAll() {
        return new ArrayList<>(diaries);
    }


    @Override
    public Diary findById(String username) {
        for (Diary diary : diaries) {
            if (diary.getUsername().equals(username)) return diary;
        }
        throw new RuntimeException("You have to create entry");
    }
    @Override
    public long count() {
        return diaries.size();
    }

    @Override
    public void delete(String username) {
        Diary diary1 = findById(username);
        if (diary1 != null) {
            diaries.remove(diary1);
        }

    }

    @Override
    public void delete(Diary diary) {
        diaries.remove(diary);
    }
}
