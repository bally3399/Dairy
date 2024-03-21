package services;

import data.model.Entry;
import data.repository.EntryRepository;
import data.repository.EntryRepositoryImplement;
import dtos.requests.CreateEntryRequest;
import exception.DiaryNotFound;
import exception.EntryNotFoundForUser;


import java.util.List;

public class EntryServicesImpl implements EntryServices{
    private static EntryRepository repository = new EntryRepositoryImplement();
    @Override
    public List<Entry> getEntriesFor(String username) {
        List<Entry> entries = repository.findByAuthor(username);
        if(entries.isEmpty()) throw new DiaryNotFound("Diary not found");
        return entries;
    }

    @Override
    public Entry createNewEntryWith(String username) {
        Entry newEntry = new Entry();
        newEntry.setAuthor(username);
        return newEntry;
    }

    @Override
    public void deleteWith(String title) {
        Entry entry = repository.findByTitle(title);
        if (entry == null) throw new EntryNotFoundForUser("No entry found");
        repository.delete(entry);
    }

    @Override
    public void addEntry(CreateEntryRequest createEntryRequest) {
        Entry entry = new Entry();
        entry.setAuthor(createEntryRequest.getAuthor());
        entry.setTitle(createEntryRequest.getTitle());
        entry.setBody(createEntryRequest.getBody());
        repository.save(entry);
    }

    @Override
    public int getNumberOfEntries() {
        return repository.findAll().size();
    }

}
