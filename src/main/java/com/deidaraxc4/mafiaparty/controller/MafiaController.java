package com.deidaraxc4.mafiaparty.controller;

import com.deidaraxc4.mafiaparty.exception.GameFullException;
import com.deidaraxc4.mafiaparty.exception.GameSessionNotFoundException;
import com.deidaraxc4.mafiaparty.model.GameSession;
import com.deidaraxc4.mafiaparty.model.Player;
import com.deidaraxc4.mafiaparty.request.PlayerRequestBody;
import com.deidaraxc4.mafiaparty.service.MafiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("mafiaGame")
public class MafiaController {

    private MafiaService mafiaService;

    @Autowired
    public MafiaController(MafiaService mafiaService) {
        this.mafiaService = mafiaService;
    }

    @PostMapping
    public GameSession createMafiaGame(@RequestBody PlayerRequestBody player) {
        return mafiaService.createMafiaGame(player);
    }

    @PatchMapping(value = "/{gameSessionId}")
    public Player joinMafiaGame(@RequestBody PlayerRequestBody player, @PathVariable int gameSessionId)
        throws GameFullException, GameSessionNotFoundException {
        return mafiaService.joinMafiaGame(player,gameSessionId);
    }

    @PostMapping(value = "assign-roles/{gameSessionId}")
    public GameSession assignRoles(@PathVariable int gameSessionId)
        throws GameSessionNotFoundException {
        return mafiaService.assignRoles(gameSessionId);
    }



}