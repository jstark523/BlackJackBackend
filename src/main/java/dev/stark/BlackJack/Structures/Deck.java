package dev.stark.BlackJack.Structures;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.Stack;

@Document(collection = "decks")
@Data
@AllArgsConstructor
public class Deck {
    @Id
    private ObjectId id;
    private int tableNumber = 1;
    private int cardsRemain;
    private int turn = 0;
    private Stack<Card> deck;

    public Deck(){
        this.cardsRemain = 52;
        Stack<Card> deck = new Stack<>();
        for(Suit suit: Suit.values()){
            for(Type type: Type.values()){
                Card card = new Card(suit, type);
                deck.push(card);
            }
        }
        this.deck = deck;
    }

    public void shuffle(){
        Collections.shuffle(this.deck);
    }

    public Card draw(){
        this.cardsRemain--;
        return this.deck.pop();
    }


}
