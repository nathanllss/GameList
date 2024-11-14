package com.nathan.study.gamelist.services;

import com.nathan.study.gamelist.dto.GameListDTO;
import com.nathan.study.gamelist.projections.GameMinProjection;
import com.nathan.study.gamelist.repositories.GameListRepository;
import com.nathan.study.gamelist.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;


    @Transactional
    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream()
                .map(GameListDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId,list.get(i).getId(),i);
        }

    }
}
