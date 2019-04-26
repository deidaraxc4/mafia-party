package com.deidaraxc4.mafiaparty.service.impl;

import com.deidaraxc4.mafiaparty.constants.CustomTypes.GameState;
import com.deidaraxc4.mafiaparty.constants.CustomTypes.PlayerRole;
import com.deidaraxc4.mafiaparty.constants.CustomTypes.PlayerState;
import com.deidaraxc4.mafiaparty.exception.GameFullException;
import com.deidaraxc4.mafiaparty.exception.GameSessionNotFoundException;
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
    private static final int MAXIMUM_PLAYERS = 16;

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

    @Override
    public Player joinMafiaGame(PlayerRequestBody player, int gameSessionId)
            throws GameFullException, GameSessionNotFoundException {
        GameSession gameSession = gameSessionRepository.findById(gameSessionId)
                .orElseThrow( () -> new GameSessionNotFoundException());
        if(gameSession.getPlayerCount() >= MAXIMUM_PLAYERS) {
            throw new GameFullException();
        }
        Player p = new Player();
        p.setPlayerName(player.getPlayerName());
        p.setStatus(PlayerState.ALIVE.toString());
        p.setGameSessionId(gameSessionId);

        p.setGameSession(gameSession);
        playerRepository.save(p);
        List list = gameSession.getPlayers();
        list.add(p);
        gameSession.setPlayers(list);
        gameSession.setPlayerCount(gameSession.getPlayerCount() + 1);
        gameSessionRepository.save(gameSession);
        return p;
    }

    @Override
    public GameSession assignRoles(int gameSessionId) throws GameSessionNotFoundException {
        GameSession gameSession = gameSessionRepository.findById(gameSessionId)
                .orElseThrow( () -> new GameSessionNotFoundException());

        gameSession.getPlayers().stream().forEach( player -> {
            if(player.getPlayerRole()!=null && player.getPlayerRole().equals("Narrator")) {

            } else {
                player.setPlayerRole(PlayerRole.getRandomRole().toString());
            }
        });
        gameSessionRepository.save(gameSession);

        return gameSession;
    }

    @Override
    public GameSession changeState(int gameSessionId) throws GameSessionNotFoundException {
        GameSession gameSession = gameSessionRepository.findById(gameSessionId)
                .orElseThrow( () -> new GameSessionNotFoundException());

        if(gameSession.getGameState().equals(GameState.MORNING.toString())) {
            gameSession.setGameState(GameState.EVENING.toString());
        } else if(gameSession.getGameState().equals(GameState.EVENING.toString())) {
            gameSession.setGameState(GameState.MORNING.toString());
        }
        gameSessionRepository.save(gameSession);
        return gameSession;
    }

    @Override
    public GameSession startGame(int gameSessionId) throws GameSessionNotFoundException {
        GameSession gameSession = gameSessionRepository.findById(gameSessionId)
                .orElseThrow( () -> new GameSessionNotFoundException());

        gameSession.setGameState(GameState.MORNING.toString());
        gameSessionRepository.save(gameSession);
        return gameSession;
    }

    @Override
    public GameSession endGame(int gameSessionId) throws GameSessionNotFoundException {
        GameSession gameSession = gameSessionRepository.findById(gameSessionId)
                .orElseThrow( () -> new GameSessionNotFoundException());

        gameSession.setGameState(GameState.END.toString());
        gameSessionRepository.save(gameSession);
        return gameSession;
    }

}
