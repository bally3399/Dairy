package services;

import data.model.Entry;

import java.util.List;

public interface EntryServices {
    List<Entry> getEntriesFor(String username);

    Entry createNewEntryWith(String username);
}
