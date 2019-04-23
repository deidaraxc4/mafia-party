package com.deidaraxc4.mafiaparty.repository;

import com.deidaraxc4.mafiaparty.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player,Integer> {

}
