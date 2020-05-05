package com.qa.service;

import com.qa.domain.Game;
import com.qa.dto.GameDTO;
import com.qa.exceptions.GameNotFoundException;
import com.qa.repo.GamesRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService {

    private final GamesRepo repo;
    private final ModelMapper mapper;

    @Autowired
    public GamesService(GamesRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public GameDTO mapToDTO(Game game){
        return this.mapper.map(game,GameDTO.class);
    }

    public List<Game> readGames(){
        return this.repo.findAll();
    }

    public Game createGame(Game game){
        return this.repo.save(game);
    }

    public Game findGameById(Long id){
        return this.repo.findById(id).orElseThrow(GameNotFoundException::new);
    }

    // This way, it will keep the original data if it has not been changed?
    public Game updateGame(Long id, Game game){
        Game update = findGameById(id);
        update.setTitle(game.getTitle());
        update.setDescription(game.getDescription());
        update.setReleaseDate(game.getReleaseDate());
        update.setPrice(game.getPrice());
        return this.repo.save(update);
    }

    public boolean deleteGame(Long id){
        if(!this.repo.existsById(id)){
            throw new GameNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
