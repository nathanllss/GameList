package com.nathan.study.gamelist.controllers;

import com.nathan.study.gamelist.dto.GameListDTO;
import com.nathan.study.gamelist.dto.GameMinDTO;
import com.nathan.study.gamelist.services.GameListService;
import com.nathan.study.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {
        return ResponseEntity.ok(gameListService.findAll());
    }

    @GetMapping("/{id}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable("id") Long listId) {
        return ResponseEntity.ok(gameService.findByList(listId));
    }
}

