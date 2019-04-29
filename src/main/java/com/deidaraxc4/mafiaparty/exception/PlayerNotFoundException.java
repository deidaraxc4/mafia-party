package com.deidaraxc4.mafiaparty.exception;

public class PlayerNotFoundException extends Exception {

    public PlayerNotFoundException(String message) {
        super(message);
    }

    public PlayerNotFoundException() {
        this("Player was not found");
    }

}
