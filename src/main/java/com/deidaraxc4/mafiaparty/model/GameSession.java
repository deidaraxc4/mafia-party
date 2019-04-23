package com.deidaraxc4.mafiaparty.model;

import com.deidaraxc4.mafiaparty.constants.CustomTypes.GameState;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gamesession")
public class GameSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gamesession_id")
    private int gameSessionId;

    @Column(name = "game_state")
    private String gameState;

    @Column(name = "player_count")
    private int playerCount;

    @OneToMany
    @JoinColumn(name = "gamesession_id")
    private List<Player> players;

    public GameSession() {

    }

    public GameSession(String gameState, int playerCount,
            List<Player> players) {
        this.gameState = gameState;
        this.playerCount = playerCount;
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(int gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }


}
