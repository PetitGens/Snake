package me.petitgens.snake;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("grid.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);

        GridController controller = fxmlLoader.getController();
        scene.setOnKeyPressed(event -> controller.onKeyPressed(event));

        stage.setTitle("Snake");
        stage.setScene(scene);
        stage.show();
    }
}
