package me.petitgens.snake.model;

public class Fruit extends Square{
    private boolean eaten = false;
    @Override
    public boolean isSolid() {
        return false;
    }

    public void eat(){
        eaten = true;
    }

    public boolean isEaten(){
        return eaten;
    }
}
