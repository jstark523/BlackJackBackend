package dev.stark.BlackJack.Structures;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.EnumMap;

enum Suit{
    DIAMOND,
    HEART,
    CLUB,
    SPADE
}

enum Type{
    ACE,
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING
}
@Data
@Document(collection = "cards")
@NoArgsConstructor
public class Card implements Serializable{
    private static final long serialVersionUID = 1L;
    private Suit suit;
    private int val;
    private Type selfType;
    private String imgPath;
    private static final EnumMap<Type, Integer> valueMap = new EnumMap<>(Type.class);

    static {
        valueMap.put(Type.ACE, 1);
        valueMap.put(Type.TWO, 2);
        valueMap.put(Type.THREE, 3);
        valueMap.put(Type.FOUR, 4);
        valueMap.put(Type.FIVE, 5);
        valueMap.put(Type.SIX, 6);
        valueMap.put(Type.SEVEN, 7);
        valueMap.put(Type.EIGHT, 8);
        valueMap.put(Type.NINE, 9);
        valueMap.put(Type.TEN, 10);
        valueMap.put(Type.JACK, 10);
        valueMap.put(Type.QUEEN, 10);
        valueMap.put(Type.KING, 10);
    }

    Card(Suit suit, Type type){
        this.suit = suit;
        this.selfType = type;
        this.val = Card.valueMap.get(type);
        this.imgPath = ("./resources/"  + this.selfType + this.suit + ".png");
    }

    public Suit getSuit() {
        return this.suit;
    }

    public int getValue() {
        return val;
    }

    public Type getType() {
        return selfType;
    }
}
