package com.nathan.study.gamelist.services;

import com.nathan.study.gamelist.dto.GameDTO;
import com.nathan.study.gamelist.dto.GameMinDTO;
import com.nathan.study.gamelist.entities.Game;
import com.nathan.study.gamelist.repositories.GameRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;


    @Transactional
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).collect(Collectors.toList());
    }
}
