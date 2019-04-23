package com.deidaraxc4.mafiaparty.service.impl;

import com.deidaraxc4.mafiaparty.model.Player;
import com.deidaraxc4.mafiaparty.repository.PlayerRepository;
import com.deidaraxc4.mafiaparty.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    //TODO implement optional where if not found then throw an exceaption and have a exception handler
    public Player findPlayerById(Integer id) {
        return playerRepository.findById(id).get();
    }

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

}
