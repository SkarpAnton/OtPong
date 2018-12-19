
package pong.ui.menu.pause;

import javafx.scene.layout.Pane;
import pong.ui.game.GameController;
import pong.ui.menu.MenuController;
import pong.ui.menu.starting.StartingMenuController;
import pong.ui.menu.starting.StartingMenuElements;


public class PauseController extends MenuController {

    private final GameController gameController;
    
    public PauseController(PauseElements menu, GameController gameController) {
        super(menu);
        this.gameController = gameController;
        gameController.stop();
    }

    @Override
    protected void addAndModifyChildren(Pane root) {}

    @Override
    protected void activate() {
        if (currentElement == 0) {
            stage.setScene(gameController.getScene());
            gameController.start();
        } else {
            runController(new StartingMenuController(new StartingMenuElements()));
        }
    }
    
}
