package org.koritsas.vinnslu.security.exceptions;

public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String message){super(message);}

    public EmailExistsException(String message,Throwable throwable){super(message,throwable);}
}
