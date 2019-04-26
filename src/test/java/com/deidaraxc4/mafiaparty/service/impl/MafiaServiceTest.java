package com.deidaraxc4.mafiaparty.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.deidaraxc4.mafiaparty.constants.CustomTypes.GameState;
import com.deidaraxc4.mafiaparty.constants.CustomTypes.PlayerRole;
import com.deidaraxc4.mafiaparty.exception.GameFullException;
import com.deidaraxc4.mafiaparty.exception.GameSessionNotFoundException;
import com.deidaraxc4.mafiaparty.model.GameSession;
import com.deidaraxc4.mafiaparty.model.Player;
import com.deidaraxc4.mafiaparty.repository.GameSessionRepository;
import com.deidaraxc4.mafiaparty.repository.PlayerRepository;
import com.deidaraxc4.mafiaparty.request.PlayerRequestBody;
import java.util.ArrayList;
import java.util.Optional;
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
        PlayerRequestBody player;
        GameSession gameSession;
        Executable test = () -> {
            gameSession = mafiaService.createMafiaGame(player);
        };

        @BeforeEach
        void beforeEach() {
            player = new PlayerRequestBody();
            player.setPlayerName("some player");
        }

        @Test
        void shouldCreateNewGameSession() throws Throwable {
            test.execute();
            assertEquals(gameSession.getPlayers().get(0).getPlayerName(),"some player");
            assertEquals(gameSession.getPlayers().get(0).getPlayerRole(), PlayerRole.Narrator.toString());
            assertEquals(gameSession.getPlayerCount(), 1);
            assertEquals(gameSession.getGameState(), GameState.LOBBY.toString());
        }
    }

    @Nested
    class joinMafiaGame {
        GameSession gameSession;
        int gameSessionId = 1;
        PlayerRequestBody playerRequestBody;
        Player player;
        Executable test = () -> {
            player = mafiaService.joinMafiaGame(playerRequestBody, gameSessionId);
        };

        @BeforeEach
        void beforeEach() {
            gameSession = new GameSession();
            playerRequestBody = new PlayerRequestBody();
            gameSession.setGameSessionId(gameSessionId);
            gameSession.setPlayers(new ArrayList<>());
            gameSession.setPlayerCount(0);
            gameSession.setGameState(GameState.LOBBY.toString());
            Optional<GameSession> optionalGameSession = Optional.of(gameSession);
            when(gameSessionRepository.findById(eq(gameSessionId))).thenReturn(optionalGameSession);
            playerRequestBody.setPlayerName("some player");
        }

        @Test
        void shouldJoinGame() throws Throwable {
            test.execute();
            assertEquals(gameSession.getPlayerCount(), 1);
            assertEquals(gameSession.getPlayers().get(0).getPlayerName(),"some player");
            assertEquals(player.getPlayerName(),"some player");
        }

        @Nested
        class whenGameIsNonexistent {
            Optional<GameSession> empty;

            @BeforeEach
            void beforeEach() {
                empty = Optional.empty();
                when(gameSessionRepository.findById(eq(gameSessionId))).thenReturn(empty);
            }

            @Test
            void shouldThrowAnException() {
                assertThrows(GameSessionNotFoundException.class, test);
            }
        }

        @Nested
        class whenGameIsFull {

            @BeforeEach
            void beforeEach() {
                gameSession.setPlayerCount(16);
            }

            @Test
            void shouldFailToJoin() {
                assertThrows(GameFullException.class,test);
            }
        }

    }

    @Nested
    class assignRoles {
        int gameSessionId = 1;
        GameSession gameSession;
        Executable test = () -> {
            gameSession = mafiaService.assignRoles(gameSessionId);
        };

        @BeforeEach
        void beforeEach() {
            gameSession = new GameSession();
            ArrayList<Player> list = new ArrayList<>();
            for(int i = 0; i < 15; i++) {
                Player p = new Player();
                p.setPlayerName("Player "+i);
                list.add(p);
            }
            gameSession.setPlayers(list);
            gameSession.setGameSessionId(gameSessionId);
            gameSession.setPlayerCount(15);
            Optional<GameSession> optionalGameSession = Optional.of(gameSession);
            when(gameSessionRepository.findById(eq(gameSessionId))).thenReturn(optionalGameSession);
        }

        @Test
        void shouldAssignRolesToEachPlayer() throws Throwable {
            test.execute();
            gameSession.getPlayers().stream().forEach( player -> {
                assertNotNull(player.getPlayerRole());
            });
        }

        @Nested
        class whenGameIsNonexistent {
            Optional<GameSession> empty;

            @BeforeEach
            void beforeEach() {
                empty = Optional.empty();
                when(gameSessionRepository.findById(eq(gameSessionId))).thenReturn(empty);
            }

            @Test
            void shouldThrowAnException() {
                assertThrows(GameSessionNotFoundException.class, test);
            }
        }

    }

    @Nested
    class changeState {
        GameSession gameSession;
        int gameSessionId = 1;
        Executable test = () -> {
            gameSession = mafiaService.changeState(gameSessionId);
        };

        @BeforeEach
        void beforeEach() {
            gameSession = new GameSession();
            Optional<GameSession> optionalGameSession = Optional.of(gameSession);
            when(gameSessionRepository.findById(eq(gameSessionId))).thenReturn(optionalGameSession);
        }

        @Test
        void shouldStartGame() throws GameSessionNotFoundException {
            assertEquals(mafiaService.startGame(gameSessionId).getGameState(),GameState.MORNING.toString());
        }

        @Test
        void shouldEndGame() throws GameSessionNotFoundException {
            assertEquals(mafiaService.endGame(gameSessionId).getGameState(),GameState.END.toString());
        }

        @Test
        void shouldChangeDayTime() throws Throwable {
            gameSession.setGameState(GameState.MORNING.toString());
            test.execute();
            assertEquals(gameSession.getGameState(),GameState.EVENING.toString());
            test.execute();
            assertEquals(gameSession.getGameState(),GameState.MORNING.toString());
        }

    }

}
