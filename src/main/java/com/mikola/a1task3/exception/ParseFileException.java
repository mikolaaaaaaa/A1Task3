package com.mikola.a1task3.exception;

public class ParseFileException extends Exception {
    public ParseFileException(String message) {
        super(message);
    }

    public ParseFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseFileException(Throwable cause) {
        super(cause);
    }
}
