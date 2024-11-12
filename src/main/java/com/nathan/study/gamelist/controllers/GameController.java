package com.nathan.study.gamelist.controllers;

import com.nathan.study.gamelist.dto.GameDTO;
import com.nathan.study.gamelist.dto.GameMinDTO;
import com.nathan.study.gamelist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> findbyId(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> findAll() {
        return ResponseEntity.ok(gameService.findAll());
    }
}

