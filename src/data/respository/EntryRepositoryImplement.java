package data.respository;

import data.model.Diary;
import data.model.Entry;

import java.util.ArrayList;
import java.util.List;


public class EntryRepositoryImplement implements EntryRepository{
    private List<Entry> entries = new ArrayList<>();

    @Override
    public Entry save(Entry entry) {
        entries.add(entry);
        return entry;
    }


    @Override
    public List<Entry> findAll() {
        return null;
    }

    @Override
    public Entry findById(int id) {
        return null;
    }

    @Override
    public long count() {
        return entries.size();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Entry entry) {

    }
}
