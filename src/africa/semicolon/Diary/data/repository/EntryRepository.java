package africa.semicolon.Diary.data.repository;

import africa.semicolon.Diary.data.model.Entry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EntryRepository extends MongoRepository<Entry, String> {
    List<Entry> findByAuthor(String username);

    Entry findByTitle(String title);
}
