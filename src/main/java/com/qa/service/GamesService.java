package com.qa.service;

import com.qa.repo.GamesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamesService {

    public final GamesRepo repo;

    @Autowired
    public GamesService(GamesRepo repo) {
        this.repo = repo;
    }



}
