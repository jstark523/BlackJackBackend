package dev.stark.BlackJack.Structures;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardObj {
    private int playerIndex;
    private Card card;
}
