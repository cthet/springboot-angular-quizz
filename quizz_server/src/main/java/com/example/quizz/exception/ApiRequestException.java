package com.example.quizz.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ApiRequestException extends RuntimeException{

    private final HttpStatus status;

    public ApiRequestException(String message, HttpStatus status){
        super(message);
        this.status = status;
    }

}
