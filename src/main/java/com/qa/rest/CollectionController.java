package com.qa.rest;

import com.qa.domain.Collection;
import com.qa.domain.Game;
import com.qa.dto.CollectionDTO;
import com.qa.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CollectionDTO>> getAllCollections(){
        return ResponseEntity.ok(this.service.readCollections());
    }

    @PostMapping("/createCollection")
    public ResponseEntity<CollectionDTO> createCollection(@RequestBody Collection collection){
        return new ResponseEntity<CollectionDTO>(this.service.createCollection(collection), HttpStatus.CREATED);
    }

    @GetMapping("/getCollectionById/{id}")
    public ResponseEntity<CollectionDTO> getCollectionById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.findCollectionById(id));
    }

    @PutMapping("/updateCollection/{id}")
    public ResponseEntity<CollectionDTO> updateCollection(@PathVariable Long id, @RequestBody Collection collection){
        return ResponseEntity.ok(this.service.updateCollection(id, collection));
    }

    @DeleteMapping("/deleteCollection/{id}")
    public ResponseEntity<?> deleteCollection(@PathVariable Long id){
        return this.service.deleteCollection(id)
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
                : ResponseEntity.noContent().build();
    }
}
