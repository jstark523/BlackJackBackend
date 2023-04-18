package dev.stark.BlackJack.Repositories;

import dev.stark.BlackJack.Structures.Player;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player, ObjectId> {
    public Optional<Player> findPlayerByName(String name);

    public Player findPlayerByPlayerIndex(int playerIndex);

}
