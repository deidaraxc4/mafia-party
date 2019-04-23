package com.deidaraxc4.mafiaparty.service;

import com.deidaraxc4.mafiaparty.model.GameSession;
import java.util.List;

public interface GameSessionService {

    /**
     * Get a GameSession by id
     * @param id The gameSession id
     * @return The GameSession
     */
    GameSession findGameSessionById(Integer id);

    /**
     * Get a list of all GameSessions
     * @return List of GameSession
     */
    List<GameSession> findAllGameSessions();

    /**
     * Create a new GameSession
     * @param gameSession The GameSession object
     * @return The created GameSession
     */
    GameSession createGameSession(GameSession gameSession);

}
