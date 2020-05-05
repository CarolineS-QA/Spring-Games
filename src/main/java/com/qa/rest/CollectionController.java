package com.qa.rest;

import com.qa.domain.Collection;
import com.qa.domain.Game;
import com.qa.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CollectionController {
    public final CollectionService service;

    @Autowired
    public CollectionController(CollectionService service) {
        this.service = service;
    }

    @GetMapping("/getAllCollections")
    public List<Collection> getAllCollections(){
        return this.service.readCollections();
    }

    @PostMapping("/createCollection")
    public Collection createCollection(@RequestBody Collection collection){
        return this.service.createCollection(collection);
    }

    @GetMapping("/getCollectionById/{id}")
    public Collection getCollectionById(@PathVariable Long id){
        return this.service.findCollectionById(id);
    }

    @PutMapping("/updateCollection/{id}")
    public Collection updateCollection(@PathVariable Long id, @RequestBody Collection collection){
        return this.service.updateCollection(id, collection);
    }

    @DeleteMapping("/deleteCollection/{id}")
    public boolean deleteCollection(@PathVariable Long id){
        return this.service.deleteCollection(id);
    }
}
