package dev.stark.BlackJack.Services;

import dev.stark.BlackJack.Structures.Card;
import dev.stark.BlackJack.Structures.CardObj;
import dev.stark.BlackJack.Structures.Player;
import dev.stark.BlackJack.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<Player> allPlayers(){
        return playerRepository.findAll();
    }
    public Optional<Player> onePlayer(String name){
        return playerRepository.findPlayerByName(name);
    }

    public Card postUserCard(Card card, String name){
        Query query = new Query(Criteria.where("name").is(name));
        Update update = new Update().addToSet("currentHand", card);

        mongoTemplate.updateFirst(query, update, Player.class);

        return card;
    }

    public void clearAllPlayerCards(){
        List<Player> players = playerRepository.findAll();
        for (Player player: players) {
            player.setCurrentHand(Collections.emptyList());
            playerRepository.save(player);
        }
    }

    public List<CardObj> currentCards(){
        List<Player> players = playerRepository.findAll();
        List<CardObj> curCards = new ArrayList<>();
        for (Player player: players) {
            List<Card> playerCards = player.getCurrentHand();
            for (Card card: playerCards){
                CardObj cardObj = new CardObj(player.getPlayerIndex(), card);
                curCards.add(cardObj);
            }
        }
        return curCards;
    }
    public void postUserName(String name){
        Player player = playerRepository.findPlayerByPlayerIndex(6);

        player.setName(name);

        playerRepository.save(player);
    }
}
