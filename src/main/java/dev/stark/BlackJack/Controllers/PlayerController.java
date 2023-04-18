package dev.stark.BlackJack.Controllers;

import dev.stark.BlackJack.Structures.Card;
import dev.stark.BlackJack.Structures.CardObj;
import dev.stark.BlackJack.Structures.Player;
import dev.stark.BlackJack.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stats")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Player>> getPlayers(){
        return new ResponseEntity<List<Player>>(playerService.allPlayers(), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping({"/{name}"})
    public ResponseEntity<Optional<Player>> getOnePlayer(@PathVariable String name){
        return new ResponseEntity<Optional<Player>>(playerService.onePlayer(name), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/{name}/update")
    public ResponseEntity<Card> postPlayerCard(@PathVariable String name, @RequestBody Card card) {
        return new ResponseEntity<>(playerService.postUserCard(card, name), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/clear")
    public ResponseEntity<String> clearPlayerCards() {
        playerService.clearAllPlayerCards();
        return new ResponseEntity<String>("Cards Cleared", HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping({"/current"})
    public ResponseEntity<List<CardObj>> getCurrentCards(){
        return new ResponseEntity<List<CardObj>>(playerService.currentCards(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/newName")
    public ResponseEntity postUserName(@RequestBody String name) {
        playerService.postUserName(name);
        System.out.println(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
