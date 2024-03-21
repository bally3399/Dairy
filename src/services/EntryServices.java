package services;

import data.model.Entry;
import dtos.requests.CreateEntryRequest;

import java.util.List;

public interface EntryServices {
    List<Entry> getEntriesFor(String username);

    Entry createNewEntryWith(String username);

    void deleteWith(String title);
    void addEntry(CreateEntryRequest createEntryRequest);

    int getNumberOfEntries();
}
