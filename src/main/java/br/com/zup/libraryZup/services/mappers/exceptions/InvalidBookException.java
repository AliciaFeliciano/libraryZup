package br.com.zup.libraryZup.services.mappers.exceptions;

public class InvalidBookException extends RuntimeException {
    public InvalidBookException(String message) {
        super(message);
    }
}
