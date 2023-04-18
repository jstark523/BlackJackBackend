package dev.stark.BlackJack.Controllers;

import dev.stark.BlackJack.Structures.History;
import dev.stark.BlackJack.Services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/history")
public class HistoryController {
    @Autowired
    private HistoryService historyService;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<History> saveHistory(@RequestBody Map<String, String> payload){
        return new ResponseEntity<>(historyService.postHistory(payload.get("status"),payload.get("values"), payload.get("name")), HttpStatus.CREATED);
    }
}
