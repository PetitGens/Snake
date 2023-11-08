package me.petitgens.snake.model;

import java.util.ArrayList;
import java.util.Random;

public class Grid {
    private Fruit fruit;

    private final Snake snake;

    private final Void VOID = Void.getInstance();

    private final Square[][] grid;
    private final int size;

    private final Random random;

    public Grid(int size){
        this.size = size;
        grid = new Square[size][size];

        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                grid[row][col] = VOID;
            }
        }

        random = new Random();
        placeFruit();

        ArrayList<SnakeBody> snakeParts = new ArrayList<>();
        snakeParts.add(new SnakeBody(4, 4));
        snakeParts.add(new SnakeBody(5, 4));
        snakeParts.add(new SnakeBody(6, 4));

        snake = new Snake(grid, snakeParts);
    }

    public void placeFruit(){
        fruit = new Fruit();
        int fruitX;
        int fruitY;

        do{
            fruitX = random.nextInt(size);
            fruitY = random.nextInt(size);
        } while(grid[fruitX][fruitY].isSolid());

        grid[fruitX][fruitY] = fruit;
    }

    public Square getSquare(int row, int column){
        return grid[row][column];
    }
}
