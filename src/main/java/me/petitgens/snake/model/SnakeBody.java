package me.petitgens.snake.model;

public class SnakeBody extends Square{
    private final int x;
    private final int y;

    public SnakeBody(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
