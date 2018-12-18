package com.marcelo.cursomc.resources.exception;

import com.marcelo.cursomc.services.exception.DataIntegratyException;
import com.marcelo.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {


        StandardError err = new StandardError(HttpStatus.NOT_FOUND, e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DataIntegratyException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegratyException e, HttpServletRequest request) {


        StandardError err = new StandardError(HttpStatus.BAD_REQUEST, e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);

    }
}