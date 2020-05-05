package com.qa.repo;

import com.qa.domain.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepo extends JpaRepository <Collection, Long> {
    Collection findCollectionByName(String name);
}
