package dev.stark.BlackJack.Services;

import dev.stark.BlackJack.Structures.History;
import dev.stark.BlackJack.Structures.Player;
import dev.stark.BlackJack.Repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    @Autowired
    private HistoryRepository historyRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public History postHistory(String status, String values, String name){
        History history = historyRepository.insert(new History(status,values));

        mongoTemplate.update(Player.class)
                .matching(Criteria .where("name").is(name))
                .apply(new Update().push("history").value(history))
                .first();

        return history;
    }
}
