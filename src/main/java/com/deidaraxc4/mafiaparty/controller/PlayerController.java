package com.deidaraxc4.mafiaparty.controller;

import com.deidaraxc4.mafiaparty.constants.CustomTypes.PlayerState;
import com.deidaraxc4.mafiaparty.model.Player;
import com.deidaraxc4.mafiaparty.service.MafiaService;
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
    public Player getPlayerById(@PathVariable Integer playerId) {
        return playerService.findPlayerById(playerId);
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        player.setStatus(PlayerState.ALIVE.toString());
        return playerService.createPlayer(player);
    }

}
