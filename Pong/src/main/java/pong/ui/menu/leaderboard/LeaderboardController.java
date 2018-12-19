
package pong.ui.menu.leaderboard;

import javafx.scene.layout.Pane;
import pong.ui.menu.MenuController;
import pong.ui.menu.starting.StartingMenuController;
import pong.ui.menu.starting.StartingMenuElements;

public class LeaderboardController extends MenuController {

    LeaderboardElements leaderboardElements;

    public LeaderboardController(LeaderboardElements leaderboardElements) {
        super(leaderboardElements);
        this.leaderboardElements = leaderboardElements;
    }

    @Override
    protected void addAndModifyChildren(Pane root) {
        root.getChildren().add(leaderboardElements.getInstruction());
        root.getChildren().add(leaderboardElements.getLeaderboard());
        root.getChildren().add(leaderboardElements.getTitle());
    }

    @Override
    protected void activate() {
        runController(new StartingMenuController(new StartingMenuElements()));
    }
}
