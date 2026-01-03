package com.foodify.user_service.exception;

public class MethodArgument extends RuntimeException{
    public MethodArgument(String message){
        super(message);
    }
}
