package com.deidaraxc4.mafiaparty.service;

import com.deidaraxc4.mafiaparty.exception.GameFullException;
import com.deidaraxc4.mafiaparty.model.GameSession;
import com.deidaraxc4.mafiaparty.model.Player;
import com.deidaraxc4.mafiaparty.request.PlayerRequestBody;

public interface MafiaService {

    /**
     * Create a new Mafia game, creates the initial player, the narrator, that joins the game
     * @param player The narrator player
     * @return newly created GameSession
     */
    GameSession createMafiaGame(PlayerRequestBody player);

    /**
     * Add a new player to existing gameSession
     * @param player The player joining
     * @param gameSessionId Existing gameSessionId
     * @throws GameFullException if the game is already full
     * @return The player that joined
     */
    Player joinMafiaGame(PlayerRequestBody player, int gameSessionId) throws GameFullException;

    /**
     * This is called when the game starts, roles are randomly assigned
     * @param gameSessionId the gameSession to assign roles to
     * @return GameSession that stated
     */
    GameSession assignRoles(int gameSessionId);

}
