package com.deidaraxc4.mafiaparty.service.impl;

import com.deidaraxc4.mafiaparty.constants.CustomTypes.PlayerRole;
import com.deidaraxc4.mafiaparty.constants.CustomTypes.PlayerState;
import com.deidaraxc4.mafiaparty.model.GameSession;
import com.deidaraxc4.mafiaparty.model.Player;
import com.deidaraxc4.mafiaparty.repository.GameSessionRepository;
import com.deidaraxc4.mafiaparty.repository.PlayerRepository;
import com.deidaraxc4.mafiaparty.service.MafiaService;
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
    public GameSession createMafiaGame(Player player) {
        player.setStatus(PlayerState.ALIVE.toString());
        player.setPlayerRole(PlayerRole.Narrator.toString());
        GameSession gameSession = new GameSession();
        gameSession.getPlayers().add(player);
        return gameSession;
    }





}
