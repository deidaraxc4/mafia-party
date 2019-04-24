package com.deidaraxc4.mafiaparty.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.deidaraxc4.mafiaparty.constants.CustomTypes.PlayerRole;
import com.deidaraxc4.mafiaparty.model.GameSession;
import com.deidaraxc4.mafiaparty.model.Player;
import com.deidaraxc4.mafiaparty.repository.GameSessionRepository;
import com.deidaraxc4.mafiaparty.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class MafiaServiceTest {

    @Mock
    GameSessionRepository gameSessionRepository;
    @Mock
    PlayerRepository playerRepository;
    @InjectMocks
    @Spy
    MafiaServiceImpl mafiaService;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Nested
    class createNewMafiaGame {
        Player player;
        GameSession gameSession;
        Executable test = () -> {
            gameSession = mafiaService.createMafiaGame(player);
        };

        @BeforeEach
        void beforeEach() {
            player = new Player();
            player.setPlayerName("some player");
        }

        @Test
        void shouldCreateNewGameSession() throws Throwable {
            test.execute();
            assertEquals(gameSession.getPlayers().get(0).getPlayerName(),"some player");
            assertEquals(gameSession.getPlayers().get(0).getPlayerRole(), PlayerRole.Narrator.toString());
        }
    }

}
