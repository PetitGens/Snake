package me.petitgens.snake.model;

public class UTurnException extends Exception{
    public UTurnException() {
    }

    public UTurnException(String message) {
        super(message);
    }

    public UTurnException(String message, Throwable cause) {
        super(message, cause);
    }

    public UTurnException(Throwable cause) {
        super(cause);
    }
}
