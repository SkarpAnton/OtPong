package pong.ui.menu.starting;

import javafx.scene.layout.Pane;
import pong.ui.menu.MenuController;
import pong.ui.menu.difficulty.DifficultyController;
import pong.ui.menu.difficulty.DifficultyElements;
import pong.ui.menu.leaderboard.LeaderboardController;
import pong.ui.menu.leaderboard.LeaderboardElements;
import pong.ui.menu.ranked.RankedController;
import pong.ui.menu.ranked.RankedElements;

public class StartingMenuController extends MenuController {

    private final StartingMenuElements menuElements;

    public StartingMenuController(StartingMenuElements menuElements) {
        super(menuElements);
        this.menuElements = menuElements;
    }

    @Override
    protected void activate() { 
        switch (currentElement) {
            case 0:
                runController(new DifficultyController(new DifficultyElements(), false));
                break;
            case 1:
                runController(new DifficultyController(new DifficultyElements(), true));
                break;
            case 2:
                runController(new RankedController(new RankedElements()));
                break;
            case 3:
                runController(new LeaderboardController(new LeaderboardElements()));
                break;
            case 4:
                System.exit(0);
        }
    }
    
    private void runController(MenuController menuController) {
        menuController.run(stage);
    }

    @Override
    protected void addAndModifyChildren(Pane root) {
        root.getChildren().add(menuElements.getTitle());
    }

}
