package me.petitgens.snake.model;

public class Wall extends Square{
    private static Wall singleton;

    @Override
    public boolean isSolid() {
        return false;
    }

    private Wall(){}

    public static Wall getInstance(){
        if(singleton == null){
            singleton = new Wall();
        }
        return singleton;
    }
}
