package me.petitgens.snake.model;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private LinkedList<SnakeBody> body;
    private Square[][] grid;

    private final Void VOID = Void.getInstance();

    public Snake(Square[][] grid, List<SnakeBody> body){
        this.grid = grid;
        this.body = new LinkedList<>();

        for(SnakeBody part : body){
            this.body.addLast(part);
            this.grid[part.getY()][part.getX()] = part;
        }
    }

    public void move(Direction direction) throws UTurnException, DeathException {
        int newHeadX = body.getFirst().getX();
        int newHeadY = body.getFirst().getY();

        switch (direction){
            case UP:
                newHeadY--;
                break;
            case DOWN:
                newHeadY++;
                break;
            case LEFT:
                newHeadX--;
                break;
            case RIGHT:
                newHeadX++;
                break;
            default:
                throw new IllegalArgumentException("unkown Direction");
        }

        checkUTurnMove(newHeadX, newHeadY);

        if(newHeadX < 0 || newHeadX >= grid.length || newHeadY < 0 || newHeadY >= grid.length){
            throw new DeathException();
        }

        System.out.println(newHeadX + " / " + newHeadY);
        Square destinationSquare = grid[newHeadY][newHeadX];

        //System.out.println(destinationSquare.getClass().getName());

        if(destinationSquare.isSolid()){
            throw new DeathException();
        }

        body.addFirst(new SnakeBody(newHeadX, newHeadY));
        grid[newHeadY][newHeadX] = body.getFirst();

        if(destinationSquare instanceof Fruit){
            ((Fruit)destinationSquare).eat();
        } else{
            SnakeBody tail = body.getLast();
            grid[tail.getY()][tail.getX()] = VOID;
            body.removeLast();
        }
    }

    private void checkUTurnMove(int newHeadX, int newHeadY) throws UTurnException {
        SnakeBody secondPart = body.get(1);
        if(newHeadX == secondPart.getX() && newHeadY == secondPart.getY()){
            throw new UTurnException("you cannot u-turn with your snake dude");
        }
    }
}
