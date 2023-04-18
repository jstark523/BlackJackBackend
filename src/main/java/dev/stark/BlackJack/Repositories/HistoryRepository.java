package dev.stark.BlackJack.Repositories;

import dev.stark.BlackJack.Structures.History;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends MongoRepository<History, ObjectId> {
}
