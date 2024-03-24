package africa.semicolon.Diary.data.repository;

import africa.semicolon.Diary.data.model.Diary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Repository
public interface DiaryRepository extends MongoRepository <Diary, String>{
    Diary findDiaryByUsername(String username);

}
