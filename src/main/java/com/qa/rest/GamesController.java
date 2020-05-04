package com.qa.rest;

import com.qa.domain.Game;
import com.qa.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Game> getAllNotes(){
        return this.service.readGames();
    }

    @PostMapping("/createGame")
    public Game createGame(@RequestBody Game game){
        return this.service.createGame(game);
    }

    @GetMapping("/getGameById/{id}")
    public Game getGameById(@PathVariable Long id){
        return this.service.findGameById(id);
    }

    @PutMapping("/updateGame/{id}")
    public Game updateGame(@PathVariable Long id, @RequestBody Game game){
        return this.service.updateGame(id, game);
    }

    @DeleteMapping("/deleteGame/{id}")
    public boolean deleteNote(@PathVariable Long id){
        return this.service.deleteGame(id);
    }
}
