package com.deidaraxc4.mafiaparty.service.impl;

import com.deidaraxc4.mafiaparty.constants.CustomTypes.GameState;
import com.deidaraxc4.mafiaparty.constants.CustomTypes.PlayerRole;
import com.deidaraxc4.mafiaparty.constants.CustomTypes.PlayerState;
import com.deidaraxc4.mafiaparty.model.GameSession;
import com.deidaraxc4.mafiaparty.model.Player;
import com.deidaraxc4.mafiaparty.repository.GameSessionRepository;
import com.deidaraxc4.mafiaparty.repository.PlayerRepository;
import com.deidaraxc4.mafiaparty.request.PlayerRequestBody;
import com.deidaraxc4.mafiaparty.service.MafiaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MafiaServiceImpl implements MafiaService {

    private GameSessionRepository gameSessionRepository;
    private PlayerRepository playerRepository;

    @Autowired
    public MafiaServiceImpl(GameSessionRepository gameSessionRepository, PlayerRepository playerRepository) {
        this.gameSessionRepository = gameSessionRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public GameSession createMafiaGame(PlayerRequestBody player) {
        GameSession gameSession = new GameSession();
        Player p = new Player();
        gameSession.setGameState(GameState.LOBBY.toString());
        gameSessionRepository.save(gameSession);
        p.setPlayerName(player.getPlayerName());
        p.setStatus(PlayerState.ALIVE.toString());
        p.setPlayerRole(PlayerRole.Narrator.toString());
        p.setGameSessionId(gameSession.getGameSessionId());
        p.setGameSession(gameSession);
        playerRepository.save(p);
        gameSession.setPlayers(new ArrayList<>());
        gameSession.getPlayers().add(p);
        gameSession.setPlayerCount(gameSession.getPlayerCount() + 1);
        gameSessionRepository.save(gameSession);
        return gameSession;
    }





}
