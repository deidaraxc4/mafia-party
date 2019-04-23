package com.deidaraxc4.mafiaparty.service.impl;

import com.deidaraxc4.mafiaparty.model.GameSession;
import com.deidaraxc4.mafiaparty.repository.GameSessionRepository;
import com.deidaraxc4.mafiaparty.service.GameSessionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameSessionServiceImpl implements GameSessionService {

    private GameSessionRepository gameSessionRepository;

    @Autowired
    public GameSessionServiceImpl(GameSessionRepository gameSessionRepository) {
        this.gameSessionRepository = gameSessionRepository;
    }

    @Override
    public GameSession findGameSessionById(Integer id) {
        return gameSessionRepository.findById(id).get();
    }

    @Override
    public List<GameSession> findAllGameSessions() {
        return (List<GameSession>) gameSessionRepository.findAll();
    }

    @Override
    public GameSession createGameSession(GameSession gameSession) {
        return gameSessionRepository.save(gameSession);
    }

}
