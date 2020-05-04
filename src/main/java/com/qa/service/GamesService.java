package com.qa.service;

import com.qa.domain.Game;
import com.qa.repo.GamesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService {

    public final GamesRepo repo;

    @Autowired
    public GamesService(GamesRepo repo) {
        this.repo = repo;
    }

    public List<Game> readGames(){
        return this.repo.findAll();
    }

    public Game createGame(Game game){
        return this.repo.save(game);
    }


}
