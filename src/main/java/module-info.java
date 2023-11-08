module me.petitgens.snake {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.petitgens.snake to javafx.fxml;
    exports me.petitgens.snake;
}