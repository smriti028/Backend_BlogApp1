package com.BlogApp1.exception;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message){
        super(message);
    }
}
