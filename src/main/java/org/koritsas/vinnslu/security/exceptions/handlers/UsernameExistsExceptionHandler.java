package org.koritsas.vinnslu.security.exceptions.handlers;

import org.koritsas.vinnslu.security.exceptions.UsernameExistsException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UsernameExistsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UsernameExistsException.class})
    protected ResponseEntity<Object> handleUsernameExists(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();

        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}