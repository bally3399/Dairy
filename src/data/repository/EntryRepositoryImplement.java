package data.repository;

import data.model.Entry;

import java.util.ArrayList;
import java.util.List;


public class EntryRepositoryImplement implements EntryRepository {
    private List<Entry> entries = new ArrayList<>();
    private int counter = 0;


    @Override
    public Entry save(Entry entry) {
        if (isNew(entry)) {
            addIdTo(entry);
            entries.add(entry);
            System.out.println(entries);
            return entry;
        } else {
            update(entry);
            System.out.println(entries);
            return entry;
        }
    }
    private void addIdTo(Entry entry) {
        entry.setId(generateId());
    }

    private int generateId() {
        return ++counter;
    }
    private boolean isNew(Entry entry) {
        return entry.getId() == 0;
    }
    private void update(Entry entry) {
        for (Entry findEntry :entries) {
            if(findEntry.getId() == entry.getId()) {
                findEntry.setBody(entry.getBody());
                findEntry.setTitle(entry.getTitle());

            }
        }
    }
    @Override
    public List<Entry> findAll() {
        return new ArrayList<>(entries);
    }

    @Override
    public Entry findById(int id) {
        for(Entry entry: entries) if(entry.getId() == id) return entry;
        return null;
    }

    @Override
    public long count() {
        return entries.size();
    }

    @Override
    public void delete(int id) {
        Entry entry = findById(id);
        if (entry != null) {
            entries.remove(id);
        }

    }

    @Override
    public void delete(Entry entry) {
        for(Entry entry1: entries) {
            if (entry1.equals(entry)) {
                entries.remove(entry);
                break;
            }
        }
    }
}
