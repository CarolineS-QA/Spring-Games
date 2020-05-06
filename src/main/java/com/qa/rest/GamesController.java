package com.qa.rest;

import com.qa.domain.Game;
import com.qa.dto.GameDTO;
import com.qa.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GamesController {
    public final GamesService service;

    @Autowired
    public GamesController(GamesService service) {
        this.service = service;
    }

    @GetMapping("/getAllGames")
    public ResponseEntity<List<GameDTO>> getAllGames(){
        return ResponseEntity.ok(this.service.readGames());
    }

    @PostMapping("/createGame")
    public ResponseEntity<GameDTO> createGame(@RequestBody Game game){
        return new ResponseEntity<GameDTO>(this.service.createGame(game), HttpStatus.CREATED);
    }

    @GetMapping("/getGameById/{id}")
    public ResponseEntity<GameDTO> getGameById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findGameById(id));
    }

    @PutMapping("/updateGame/{id}")
    public ResponseEntity<GameDTO> updateGame(@PathVariable Long id, @RequestBody Game game){
        return ResponseEntity.ok(this.service.updateGame(id, game));
    }

    @DeleteMapping("/deleteGame/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable Long id){
        return this.service.deleteGame(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }
}
