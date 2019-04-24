package com.deidaraxc4.mafiaparty.exception.handler;

import com.deidaraxc4.mafiaparty.exception.ExceptionResponse;
import com.deidaraxc4.mafiaparty.exception.GameFullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.deidaraxc4.mafiaparty.controller")
public class MafiaExceptionHandler {

    @ExceptionHandler(GameFullException.class)
    public ResponseEntity<ExceptionResponse> gameFullExceptionHandler(Exception e) {
        ExceptionResponse response = new ExceptionResponse("The game is currently full");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
