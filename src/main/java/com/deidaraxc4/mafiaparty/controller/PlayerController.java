package com.deidaraxc4.mafiaparty.controller;

import com.deidaraxc4.mafiaparty.exception.GameSessionNotFoundException;
import com.deidaraxc4.mafiaparty.exception.PlayerNotFoundException;
import com.deidaraxc4.mafiaparty.model.Player;
import com.deidaraxc4.mafiaparty.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("player")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(value = "/{playerId}")
    public Player getPlayerById(@PathVariable Integer playerId)
            throws PlayerNotFoundException {
        return playerService.findPlayerById(playerId);
    }

    @PostMapping(value = "/{gameSessionId}")
    public Player createPlayer(@RequestBody Player player, @PathVariable int gameSessionId)
            throws GameSessionNotFoundException {
        return playerService.createPlayer(player,gameSessionId);
    }

}
