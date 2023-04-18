package dev.stark.BlackJack.Repositories;

import dev.stark.BlackJack.Structures.Deck;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeckRepository extends MongoRepository<Deck, ObjectId> {
    Optional<Deck> findDeckBytableNumber(int tableNumber);

}
