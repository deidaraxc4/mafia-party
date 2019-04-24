package com.deidaraxc4.mafiaparty.exception;

public class GameSessionNotFoundException extends Exception {

    public GameSessionNotFoundException() {
        this("Game session was not found");
    }

    public GameSessionNotFoundException(String message) {
        super(message);
    }

}
