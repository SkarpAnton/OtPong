package pong.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import pong.ui.starting_menu.StartingMenuElements;
import pong.ui.starting_menu.StartingMenuController;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        StartingMenuController startingMenuController
                = new StartingMenuController(new StartingMenuElements());
        startingMenuController.run(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
