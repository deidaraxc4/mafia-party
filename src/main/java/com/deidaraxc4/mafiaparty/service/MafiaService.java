package com.deidaraxc4.mafiaparty.service;

import com.deidaraxc4.mafiaparty.model.GameSession;
import com.deidaraxc4.mafiaparty.request.PlayerRequestBody;

public interface MafiaService {

    /**
     * Create a new Mafia game, creates the initial player, the narrator, that joins the game
     * @param player The narrator player
     * @return newly created GameSession
     */
    GameSession createMafiaGame(PlayerRequestBody player);

}
