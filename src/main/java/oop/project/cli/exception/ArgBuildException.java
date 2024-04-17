package oop.project.cli.exception;

public class ArgBuildException extends Exception {
    public ArgBuildException() {

    }

    public ArgBuildException(String message) {
        super(message);
    }

    public ArgBuildException(Throwable cause) {
        super(cause);
    }

    public ArgBuildException(String message, Throwable cause) {
        super(message, cause);
    }
}
