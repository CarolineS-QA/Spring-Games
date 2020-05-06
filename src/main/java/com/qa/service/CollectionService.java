package com.qa.service;

import com.qa.domain.Collection;
import com.qa.dto.CollectionDTO;
import com.qa.exceptions.CollectionNotFoundException;
import com.qa.repo.CollectionRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {
    private final CollectionRepo repo;

    private final ModelMapper mapper;

    @Autowired
    public CollectionService(CollectionRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    private CollectionDTO mapToDTO(Collection collection){
        return this.mapper.map(collection, CollectionDTO.class);
    }

    public List<Collection> readCollections(){
        return this.repo.findAll();
    }

    public Collection createCollection(Collection collection){
        return this.repo.save(collection);
    }

    public Collection findCollectionById(Long id){
        return this.repo.findById(id).orElseThrow(CollectionNotFoundException::new);
    }

    public Collection updateCollection(Long id, Collection collection){
        Collection update = findCollectionById(id);
        update.setName(collection.getName());
        return this.repo.save(update);
    }

    public boolean deleteCollection(Long id){
        if(!this.repo.existsById(id)){
            throw new CollectionNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
