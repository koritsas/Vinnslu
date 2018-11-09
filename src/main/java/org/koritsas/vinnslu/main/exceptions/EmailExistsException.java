package org.koritsas.vinnslu.main.exceptions;

public class EmailExistsException extends RuntimeException {

    public EmailExistsException(String message){super(message);}

    public EmailExistsException(String message,Throwable throwable){super(message,throwable);}
}
