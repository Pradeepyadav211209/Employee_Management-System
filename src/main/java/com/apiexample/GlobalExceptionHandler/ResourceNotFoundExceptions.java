package com.apiexample.GlobalExceptionHandler;

public class ResourceNotFoundExceptions extends RuntimeException{
    public ResourceNotFoundExceptions(String msg){
        super(msg);
    }
}
