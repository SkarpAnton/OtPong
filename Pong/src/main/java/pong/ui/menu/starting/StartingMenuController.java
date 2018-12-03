package pong.ui.menu.starting;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Pane;
import pong.ui.menu.MenuController;
import pong.ui.menu.difficulty.DifficultyController;
import pong.ui.menu.difficulty.DifficultyElements;

public class StartingMenuController extends MenuController {

    private StartingMenuElements menuElements;

    public StartingMenuController(StartingMenuElements menuElements) {
        super(menuElements.getMenu());
        this.menuElements = menuElements;
    }

    @Override
    protected void activate() {
        DifficultyController difficultyController;
        try {
            switch (currentItem) {
                case 0:
                    difficultyController
                            = new DifficultyController(new DifficultyElements(), false);
                    difficultyController.run(stage);
                    break;
                case 1:
                    difficultyController
                            = new DifficultyController(new DifficultyElements(), true);
                    difficultyController.run(stage);
                    break;
                case 2:
                    System.exit(0);
            }
        } catch (Exception ex) {
        }
    }

    @Override
    protected void addAdditionalChildren(Pane root) {
        root.getChildren().add(menuElements.getTitle());
    }

}
