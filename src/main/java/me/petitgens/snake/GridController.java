package me.petitgens.snake;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import me.petitgens.snake.model.*;
import me.petitgens.snake.model.Void;

import java.net.URL;
import java.util.ResourceBundle;

public class GridController implements Initializable {
    @FXML
    private GridPane gameGrid;

    private Grid gridModel;

    // Number of rows and columns
    private final int GRID_SIZE = 20;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeGridPane();

        gridModel = new Grid(GRID_SIZE);
        updateGridView();
    }

    public void initializeGridPane(){
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setFillWidth(true); // Allow columns to grow
        columnConstraints.setHgrow(Priority.ALWAYS); // Make columns grow to fill space
        gameGrid.getColumnConstraints().add(columnConstraints);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setFillHeight(true); // Allow rows to grow
        rowConstraints.setVgrow(Priority.ALWAYS); // Make rows grow to fill space
        gameGrid.getRowConstraints().add(rowConstraints);

        for(int row = 0; row < GRID_SIZE; row++){
            for(int col = 0; col < GRID_SIZE; col++){
                Rectangle cell = new Rectangle();
                cell.setFill(Color.BLACK);
                cell.widthProperty().bind(gameGrid.widthProperty().divide(GRID_SIZE)); // Divide the available width by 3
                cell.heightProperty().bind(gameGrid.heightProperty().divide(GRID_SIZE)); // Divide the available height by 3

                gameGrid.add(cell, col, row);
            }
        }
    }

    public void updateGridView(){
        for(Node node : gameGrid.getChildren()){
            Rectangle cell = (Rectangle) node;
            int col = GridPane.getRowIndex(cell);
            int row = GridPane.getColumnIndex(cell);

            Square square = gridModel.getSquare(row, col);

            if(square instanceof Void){
                cell.setFill(Color.BLACK);
            } else if (square instanceof SnakeBody) {
                cell.setFill(Color.WHITE);
            } else if (square instanceof Fruit) {
                cell.setFill(Color.RED);
            }
        }
    }


}
