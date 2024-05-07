package com.InnGen.web.controllers.exceptions;

import com.webservicecommerce.services.exceptions.DatabaseException;
import com.webservicecommerce.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError>  resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        String error  = "Resrouce not found";
        HttpStatus status =  HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(), request.getContextPath() );
      return  ResponseEntity.status(status).body(err);
    }
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError>  dataBase(DatabaseException e, HttpServletRequest request){
        String error  = "DataBase Error";
        HttpStatus status =  HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(),status.value(), error, e.getMessage(), request.getContextPath() );
        return  ResponseEntity.status(status).body(err);
    }

}
