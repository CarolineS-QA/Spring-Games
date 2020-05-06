package com.qa.service;

import com.qa.domain.Collection;
import com.qa.dto.CollectionDTO;
import com.qa.exceptions.CollectionNotFoundException;
import com.qa.repo.CollectionRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<CollectionDTO> readCollections(){
        return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public CollectionDTO createCollection(Collection collection){
        return this.mapToDTO(this.repo.save(collection));
    }

    public CollectionDTO findCollectionById(Long id){
        return this.mapToDTO(this.repo.findById(id).orElseThrow(CollectionNotFoundException::new));
    }

    public CollectionDTO updateCollection(Long id, Collection collection){
        Collection update = this.repo.findById(id).orElseThrow(CollectionNotFoundException::new);
        update.setName(collection.getName());
        Collection tempCollection = this.repo.save(update);
        return this.mapToDTO(tempCollection);
    }

    public boolean deleteCollection(Long id){
        if(!this.repo.existsById(id)){
            throw new CollectionNotFoundException();
        }
        this.repo.deleteById(id);
        return this.repo.existsById(id);
    }
}
