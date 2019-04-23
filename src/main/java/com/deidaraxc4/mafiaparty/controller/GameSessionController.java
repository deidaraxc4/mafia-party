package com.deidaraxc4.mafiaparty.controller;

import com.deidaraxc4.mafiaparty.model.GameSession;
import com.deidaraxc4.mafiaparty.service.GameSessionService;
import com.deidaraxc4.mafiaparty.service.MafiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("gameSession")
public class GameSessionController {

    private GameSessionService gameSessionService;

    @Autowired
    public GameSessionController(GameSessionService gameSessionService) {
        this.gameSessionService = gameSessionService;
    }

    @PostMapping
    public GameSession createGameSession(@RequestBody GameSession gameSession) {
        return gameSessionService.createGameSession(gameSession);
    }

    @GetMapping(value = "/{gameSessionId}")
    public GameSession getGameSessionById(@PathVariable Integer gameSessionId) {
        return gameSessionService.findGameSessionById(gameSessionId);
    }

    @GetMapping
    public List<GameSession> getAllGameSessions() {
        return gameSessionService.findAllGameSessions();
    }


}
