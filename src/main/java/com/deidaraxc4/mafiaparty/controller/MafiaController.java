package com.deidaraxc4.mafiaparty.controller;

import com.deidaraxc4.mafiaparty.constants.CustomTypes.PlayerRole;
import com.deidaraxc4.mafiaparty.constants.CustomTypes.PlayerState;
import com.deidaraxc4.mafiaparty.model.GameSession;
import com.deidaraxc4.mafiaparty.model.Player;
import com.deidaraxc4.mafiaparty.request.PlayerRequestBody;
import com.deidaraxc4.mafiaparty.service.MafiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MafiaController {

    private MafiaService mafiaService;

    @Autowired
    public MafiaController(MafiaService mafiaService) {
        this.mafiaService = mafiaService;
    }

    @PostMapping
    public GameSession createMafiaGame(Player player) {
        return mafiaService.createMafiaGame(player);
    }



}