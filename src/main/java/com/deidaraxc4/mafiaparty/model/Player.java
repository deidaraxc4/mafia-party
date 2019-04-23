package com.deidaraxc4.mafiaparty.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private int playerId;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "player_status")
    private String status;

    @Column(name = "player_role")
    private String playerRole;

    @Column(name = "gamesession_id", nullable = false)
    private int gameSessionId;

    @ManyToOne
    @JoinColumn(name = "gamesession_id", insertable = false, updatable = false)
    @JsonIgnore
    private GameSession gameSession;

    public Player() {

    }

    public Player(GameSession gameSession, String playerName,
            String status, String playerRole) {
        this.gameSession = gameSession;
        this.playerName = playerName;
        this.status = status;
        this.playerRole = playerRole;
    }

    public int getGameSessionId() {
        return gameSessionId;
    }

    public void setGameSessionId(int gameSessionId) {
        this.gameSessionId = gameSessionId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public GameSession getGameSession() {
        return gameSession;
    }

    public void setGameSession(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(String playerRole) {
        this.playerRole = playerRole;
    }

}
