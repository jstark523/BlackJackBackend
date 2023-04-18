package dev.stark.BlackJack.Structures;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "histories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class History {
    @Id
    private ObjectId id;
    private String status;
    private String values;
    public History(String status, String values) {
        this.status = status;
        this.values = values;
    }
}
