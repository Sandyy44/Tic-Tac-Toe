package TicTacToe;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        //creating an object of the overallView class and passing it the main stage
        overallView overallview = new overallView(stage);

        //displaying the stage
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
