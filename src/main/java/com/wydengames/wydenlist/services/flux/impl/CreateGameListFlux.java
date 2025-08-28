package com.wydengames.wydenlist.services.flux.impl;

import com.wydengames.wydenlist.dto.CreateGameListDTO;
import com.wydengames.wydenlist.dto.CreateGameListResponseDTO;
import com.wydengames.wydenlist.entities.GameList;
import com.wydengames.wydenlist.repositories.GameListRepository;
import com.wydengames.wydenlist.services.GameApplicationFlux;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CreateGameListFlux  implements GameApplicationFlux <CreateGameListDTO, CreateGameListResponseDTO> {


    private final GameListRepository gameListRepository;

    public CreateGameListFlux(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    @Override
    public CreateGameListResponseDTO process(CreateGameListDTO request) {
        GameList newList = createNewList(request);

        return builderResponseDTO(newList, request);
    }

    private CreateGameListResponseDTO builderResponseDTO(GameList newList, CreateGameListDTO request){
        return CreateGameListResponseDTO.builder()
            .id(newList.getId())
            .name(newList.getName())
            .build();
    }

    private GameList createNewList(CreateGameListDTO request){
        GameList newList = new GameList();

        newList.setId(request.id());
        newList.setName(request.name());

        return newList;
    }
}
