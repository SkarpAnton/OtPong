package pong.ui.menu.endgame;

import javafx.scene.layout.Pane;
import pong.ui.menu.MenuController;
import pong.ui.menu.starting.StartingMenuController;
import pong.ui.menu.starting.StartingMenuElements;

public class GameEndController extends MenuController {

    private GameEndElements gameEndElements;

    public GameEndController(GameEndElements gameEndElements) {
        super(gameEndElements);
        this.gameEndElements = gameEndElements;
    }

    @Override
    protected void addAndModifyChildren(Pane root) {
        root.getChildren().add(gameEndElements.getScore());
        root.getChildren().add(gameEndElements.getWinText());
        root.getChildren().add(gameEndElements.getInstruction());
    }

    @Override
    protected void activate() {

        StartingMenuController startingMenuController
                = new StartingMenuController(new StartingMenuElements());
        startingMenuController.run(stage);

    }
}
