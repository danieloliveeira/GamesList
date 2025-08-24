package com.wydengames.wydenlist.repositories;

import com.wydengames.wydenlist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
