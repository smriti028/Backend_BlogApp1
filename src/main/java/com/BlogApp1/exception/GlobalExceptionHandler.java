package com.BlogApp1.exception;

import com.BlogApp1.dto.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundExceptionHandler(
            ResourceNotFound e, WebRequest webRequest
    ){
        ErrorDetails error = new ErrorDetails(new Date(),e.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> GlobalExceptionHandler(
            Exception e,WebRequest webRequest
    ){
        ErrorDetails error = new ErrorDetails(new Date(),e.getMessage(),webRequest.getDescription(true));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
