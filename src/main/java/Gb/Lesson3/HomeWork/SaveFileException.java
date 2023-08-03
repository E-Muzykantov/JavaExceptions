package Gb.Lesson3.HomeWork;

import java.io.IOException;

public class SaveFileException extends IOException {
    public SaveFileException() {
        super();
    }

    public SaveFileException(String message) {
        super(message);
    }

    public SaveFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaveFileException(Throwable cause) {
        super(cause);
    }
}
