package dev.stark.BlackJack.Services;

import dev.stark.BlackJack.Repositories.DeckRepository;
import dev.stark.BlackJack.Structures.Card;
import dev.stark.BlackJack.Structures.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeckService {
    @Autowired
    private DeckRepository deckRepository;

    public Deck postNewDeck(){
        Optional<Deck> existingDeck = deckRepository.findDeckBytableNumber(1);
        Deck deck = new Deck();
        deck.shuffle();
        if(existingDeck.isPresent()){
            deckRepository.delete(existingDeck.get());
        }
        deckRepository.insert(deck);
        return deck;

    }
    public Optional<Deck> existingDeck(int number){
        return deckRepository.findDeckBytableNumber(number);
    }

    public Optional<Card> dealCard(int tableNumber){
        Optional<Deck> optionalDeck = existingDeck(tableNumber);
        if (optionalDeck.isPresent()) {
            Deck deck = optionalDeck.get();
            Card card = deck.draw();
            deckRepository.save(deck);
            return Optional.of(card);
        }
        else {
            return Optional.empty();
        }
    }



}
