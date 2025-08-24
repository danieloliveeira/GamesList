package com.wydengames.wydenlist.services;

import com.wydengames.wydenlist.dto.GameDTO;
import com.wydengames.wydenlist.dto.GameMinDTO;
import com.wydengames.wydenlist.entities.Game;
import com.wydengames.wydenlist.repositories.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

    @Transactional
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Recurso nao encontrado")
        );
        return new GameDTO(result);
    }
}
