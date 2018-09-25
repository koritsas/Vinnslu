package org.koritsas.vinnslu.exceptions;

public class EntityAlreadyExistsException extends RuntimeException{

    public EntityAlreadyExistsException(String message){super(message);}

    public EntityAlreadyExistsException(String message,Throwable throwable){super(message,throwable);}
}
