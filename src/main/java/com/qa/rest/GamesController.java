package com.qa.rest;

import com.qa.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamesController {
    public final GamesService service;

    @Autowired
    public GamesController(GamesService service) {
        this.service = service;
    }
}
