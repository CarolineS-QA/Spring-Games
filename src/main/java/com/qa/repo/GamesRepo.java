package com.qa.repo;

import com.qa.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepo extends JpaRepository<Game, Long> {
    Game findGameByTitle(String title);
}
