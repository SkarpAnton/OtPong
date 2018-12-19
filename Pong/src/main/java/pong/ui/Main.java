package pong.ui;

import javafx.application.Application;
import javafx.stage.Stage;
import pong.ui.menu.starting.StartingMenuElements;
import pong.ui.menu.starting.StartingMenuController;

/**
 * Main class of the program
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {
        stage.setResizable(false);
        StartingMenuController startingMenuController
                = new StartingMenuController(new StartingMenuElements());
        startingMenuController.run(stage);
    }

    /**
     * the main function of the program
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
