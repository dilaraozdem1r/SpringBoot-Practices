package com.springbootpractise.springbootrestapi.advice;

public class UserNotFound extends RuntimeException{

    public UserNotFound(String message){
        super(message);
    }
}
