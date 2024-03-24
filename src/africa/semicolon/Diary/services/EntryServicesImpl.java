package africa.semicolon.Diary.services;

import africa.semicolon.Diary.data.model.Entry;
import africa.semicolon.Diary.data.repository.EntryRepository;
import africa.semicolon.Diary.dtos.requests.CreateEntryRequest;
import africa.semicolon.Diary.exception.DiaryAppExceptions;
import africa.semicolon.Diary.exception.EntryNotFoundForUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class EntryServicesImpl implements EntryServices{
    @Autowired
    private EntryRepository repository;
    @Override
    public List<Entry> getEntriesFor(String username) {
        List<Entry> entries = repository.findByAuthor(username);
        if(entries.isEmpty()) throw new DiaryAppExceptions("Diary not found");
        return entries;
    }

    @Override
    public Entry createNewEntryWith(String username, String title, String body) {
        Entry newEntry = new Entry();
        newEntry.setAuthor(username);
        newEntry.setTitle(title);
        newEntry.setBody(body);
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
