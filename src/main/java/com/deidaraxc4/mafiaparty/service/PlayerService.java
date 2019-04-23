package com.deidaraxc4.mafiaparty.service;

import com.deidaraxc4.mafiaparty.model.Player;

public interface PlayerService {

    /**
     * Get a Player by playerId
     * @param id The player id
     * @return Player object
     */
    Player findPlayerById(Integer id);

    /**
     * Create a new Player object
     * @param player Player object
     * @return Player that was created
     */
    Player createPlayer(Player player);

}
