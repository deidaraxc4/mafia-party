package com.deidaraxc4.mafiaparty.exception;

public class GameFullException extends Exception {

    public GameFullException(String message) {
        super(message);
    }

    public GameFullException() {
        this("The game is currently full");
    }

}
