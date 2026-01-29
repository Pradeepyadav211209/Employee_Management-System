package com.apiexample.GlobalExceptionHandler;

import com.apiexample.Dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> globalExceptionHandler(
            Exception e,
            WebRequest request
    ){
        ErrorDto errorDto = new ErrorDto(new Date(), e.toString(),request.getDescription(true));
        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundExceptions.class)
    public ResponseEntity<ErrorDto> ResourceNotFoundExceptionHandler(
            ResourceNotFoundExceptions e,
            WebRequest request
    ){
        ErrorDto errorDto = new ErrorDto(new Date(), e.getMessage(),request.getDescription(true));
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
