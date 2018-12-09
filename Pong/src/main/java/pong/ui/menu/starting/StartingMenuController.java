package pong.ui.menu.starting;

import javafx.scene.layout.Pane;
import pong.ui.menu.MenuController;
import pong.ui.menu.difficulty.DifficultyController;
import pong.ui.menu.difficulty.DifficultyElements;
import pong.ui.menu.ranked.RankedController;
import pong.ui.menu.ranked.RankedElements;

public class StartingMenuController extends MenuController {

    private StartingMenuElements menuElements;

    public StartingMenuController(StartingMenuElements menuElements) {
        super(menuElements);
        this.menuElements = menuElements;
    }

    @Override
    protected void activate() {
        DifficultyController difficultyController;
        try {
            switch (currentElement) {
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
                    RankedController rankedController
                            = new RankedController(new RankedElements());
                    rankedController.run(stage);
                    break;
                case 3:
                    System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void addAndModifyChildren(Pane root) {
        root.getChildren().add(menuElements.getTitle());
    }

}
