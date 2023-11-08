package me.petitgens.snake.model;

public class Void extends Square{
    private static Void singleton;

    @Override
    public boolean isSolid() {
        return false;
    }

    private Void(){}

    public static Void getInstance(){
        if(singleton == null){
            singleton = new Void();
        }
        return singleton;
    }
}
