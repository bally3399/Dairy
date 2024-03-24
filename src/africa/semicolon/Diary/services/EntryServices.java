package africa.semicolon.Diary.services;

import africa.semicolon.Diary.data.model.Entry;
import africa.semicolon.Diary.dtos.requests.CreateEntryRequest;

import java.util.List;

public interface EntryServices {
    List<Entry> getEntriesFor(String username);

    Entry createNewEntryWith(String username, String title, String body);

    void deleteWith(String title);
    void addEntry(CreateEntryRequest createEntryRequest);

    int getNumberOfEntries();

}
