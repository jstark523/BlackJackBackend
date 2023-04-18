package dev.stark.BlackJack.Controllers;

        import dev.stark.BlackJack.Services.DeckService;
        import dev.stark.BlackJack.Structures.Card;
        import dev.stark.BlackJack.Structures.Deck;
        import dev.stark.BlackJack.Structures.History;
        import dev.stark.BlackJack.Structures.Player;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.Map;
        import java.util.Optional;

@RestController
@RequestMapping("/deck")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/new")
    public ResponseEntity<Deck> newDeck(){
        return new ResponseEntity<>(deckService.postNewDeck(), HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{tableNumber}")
    public ResponseEntity<Deck> getSingleDeck(@PathVariable int tableNumber) {
        Optional<Deck> optionalDeck = deckService.existingDeck(tableNumber);
        if (optionalDeck.isPresent()) {
            return new ResponseEntity<>(optionalDeck.get(), HttpStatus.OK);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{tableNumber}/deal")
    public ResponseEntity<Card> dealCard(@PathVariable int tableNumber) {
        Optional<Card> optionalCard = deckService.dealCard(tableNumber);
        if (optionalCard.isPresent()) {
            return new ResponseEntity<>(optionalCard.get(), HttpStatus.OK);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
