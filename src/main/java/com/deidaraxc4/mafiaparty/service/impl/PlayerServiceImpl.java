package com.deidaraxc4.mafiaparty.service.impl;

import com.deidaraxc4.mafiaparty.constants.CustomTypes.PlayerState;
import com.deidaraxc4.mafiaparty.exception.GameSessionNotFoundException;
import com.deidaraxc4.mafiaparty.exception.PlayerNotFoundException;
import com.deidaraxc4.mafiaparty.model.GameSession;
import com.deidaraxc4.mafiaparty.model.Player;
import com.deidaraxc4.mafiaparty.repository.GameSessionRepository;
import com.deidaraxc4.mafiaparty.repository.PlayerRepository;
import com.deidaraxc4.mafiaparty.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    PlayerRepository playerRepository;
    GameSessionRepository gameSessionRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, GameSessionRepository gameSessionRepository) {
        this.playerRepository = playerRepository;
        this.gameSessionRepository = gameSessionRepository;
    }

    @Override
    public Player findPlayerById(Integer id) throws PlayerNotFoundException {
        return playerRepository.findById(id).orElseThrow( () -> new PlayerNotFoundException());
    }

    @Override
    public Player createPlayer(Player player, int gameSessionId)
        throws GameSessionNotFoundException {
        player.setStatus(PlayerState.ALIVE.toString());
        player.setGameSessionId(gameSessionId);
        GameSession gameSession = gameSessionRepository.findById(gameSessionId)
                .orElseThrow(() -> new GameSessionNotFoundException());
        player.setGameSession(gameSession);
        return playerRepository.save(player);
    }

}
