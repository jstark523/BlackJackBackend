package dev.stark.BlackJack.Structures;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "players")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    private ObjectId id;
    private String name;
    private int playerIndex;
    private double money;
    private String picture;
    private String imdbImg;
    private List<History> history;
    private List<Card> currentHand;

}
