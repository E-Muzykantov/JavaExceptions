package Gb.Lesson3.HomeWork;

public class IncorrectFormatException extends IllegalArgumentException{
    public IncorrectFormatException() {
        super();
    }

    public IncorrectFormatException(String message) {
        super(message);
    }

    public IncorrectFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectFormatException(Throwable cause) {
        super(cause);
    }


}
