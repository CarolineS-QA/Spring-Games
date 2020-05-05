package com.qa.rest;

import com.qa.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CollectionController {
    public final CollectionService service;

    @Autowired
    public CollectionController(CollectionService service) {
        this.service = service;
    }
}
