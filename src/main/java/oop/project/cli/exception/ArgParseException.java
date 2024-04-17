package oop.project.cli.exception;

public class ArgParseException extends Exception {
    public ArgParseException() {

    }

    public ArgParseException(String message) {
        super(message);
    }

    public ArgParseException(Throwable cause) {
        super(cause);
    }

    public ArgParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
