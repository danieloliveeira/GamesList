package com.wydengames.wydenlist.controllers;

import com.wydengames.wydenlist.dto.GameListDTO;
import com.wydengames.wydenlist.dto.GameMinDTO;
import com.wydengames.wydenlist.dto.ReplacementDTO;
import com.wydengames.wydenlist.services.GameListService;
import com.wydengames.wydenlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable("listId")Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable("listId")Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
