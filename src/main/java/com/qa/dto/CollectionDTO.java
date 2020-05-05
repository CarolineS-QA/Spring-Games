package com.qa.dto;

import com.qa.domain.Game;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class CollectionDTO {
    private Long collection_id;
    private String name;
    private List<GameDTO> games = new ArrayList<>();

    public CollectionDTO() {
    }

    public CollectionDTO(String name, List<GameDTO> games) {
        this.name = name;
        this.games = games;
    }

    public Long getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(Long collection_id) {
        this.collection_id = collection_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GameDTO> getGames() {
        return games;
    }

    public void setGames(List<GameDTO> games) {
        this.games = games;
    }
}
