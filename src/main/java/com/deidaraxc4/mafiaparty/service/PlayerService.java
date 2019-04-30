package com.deidaraxc4.mafiaparty.service;

import com.deidaraxc4.mafiaparty.exception.GameSessionNotFoundException;
import com.deidaraxc4.mafiaparty.exception.PlayerNotFoundException;
import com.deidaraxc4.mafiaparty.model.Player;

public interface PlayerService {

    /**
     * Get a Player by playerId
     * @param id The player id
     * @return Player object
     */
    Player findPlayerById(Integer id) throws PlayerNotFoundException;

    /**
     * Create a new Player object
     * @param player Player object
     * @param gameSessionId The FK for the player object
     * @return Player that was created
     */
    Player createPlayer(Player player, int gameSessionId) throws GameSessionNotFoundException;

}
