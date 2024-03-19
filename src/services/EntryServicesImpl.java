package services;

import data.model.Entry;
import data.repository.DiaryRepository;
import data.repository.DiaryRepositoryImplement;
import data.repository.EntryRepository;
import data.repository.EntryRepositoryImplement;

import java.util.ArrayList;
import java.util.List;

public class EntryServicesImpl implements EntryServices{
    private static EntryRepository repository = new EntryRepositoryImplement();
    @Override
    public List<Entry> getEntriesFor(String username) {
        return repository.findByAuthor(username);
    }

    @Override
    public Entry createNewEntryWith(String username) {
        Entry newEntry = new Entry();
        newEntry.setAuthor(username);
        return newEntry;
    }

}
