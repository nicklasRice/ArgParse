package oop.project.cli.exception;

public class ParseException extends Exception {
    private final String argName;

    public ParseException(String message, String argName) {
        super(message);
        this.argName = argName;
    }

    public ParseException(Throwable cause, String argName) {
        super(cause);
        this.argName = argName;
    }

    public ParseException(String message, Throwable cause, String argName) {
        super(message, cause);
        this.argName = argName;
    }

    public String getArgName() {
        return argName;
    }
}
