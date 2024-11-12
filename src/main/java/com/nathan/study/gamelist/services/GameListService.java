package com.nathan.study.gamelist.services;

import com.nathan.study.gamelist.dto.GameListDTO;
import com.nathan.study.gamelist.entities.GameList;
import com.nathan.study.gamelist.repositories.GameListRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;
    

    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream().map(GameListDTO::new).collect(Collectors.toList());
    }
}
