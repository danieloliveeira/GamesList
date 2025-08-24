package com.wydengames.wydenlist.repositories;

import com.wydengames.wydenlist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
