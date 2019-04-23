package com.deidaraxc4.mafiaparty.repository;

import com.deidaraxc4.mafiaparty.model.GameSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameSessionRepository extends CrudRepository<GameSession,Integer> {

}
