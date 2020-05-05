package com.qa.service;

import com.qa.repo.CollectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionService {
    public final CollectionRepo repo;

    @Autowired
    public CollectionService(CollectionRepo repo) {
        this.repo = repo;
    }
}
