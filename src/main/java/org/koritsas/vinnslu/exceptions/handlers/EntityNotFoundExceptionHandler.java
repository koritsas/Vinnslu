package org.koritsas.vinnslu.exceptions.handlers;

import org.hibernate.exception.ConstraintViolationException;
import org.koritsas.vinnslu.exceptions.EntityAlreadyExistsException;
import org.koritsas.vinnslu.exceptions.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EntityNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFound(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();

        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {EntityAlreadyExistsException.class})
    protected ResponseEntity<Object> handleE(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();

        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}