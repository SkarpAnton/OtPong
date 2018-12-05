package pong.ui.menu.difficulty;

import javafx.scene.layout.Pane;
import pong.ui.menu.MenuController;
import pong.ui.game.GameController;

public class DifficultyController extends MenuController {

    private final Boolean twoPlayergame;

    public DifficultyController(DifficultyElements elements, boolean twoPlayerGame) {
        super(elements.getSettings());
        this.twoPlayergame = twoPlayerGame;
    }

    @Override
    protected void activate() {
        switch (currentElement) {
            case 0:
                int slow = 6;
                transitionToGame(slow);
                break;
            case 1:
                int normal = 8;
                transitionToGame(normal);
                break;
            case 2:
                int fast = 12;
                transitionToGame(fast);
                break;
            case 3:
                int superFast = 15;
                transitionToGame(superFast);
                break;
        }
    }
   
    private void transitionToGame(int speed) {
        GameController gameController = new GameController(twoPlayergame, speed, stage);
        stage.setScene(gameController.getScene());
    }

    @Override
    protected void addAdditionalChildren(Pane root) {
    }

}
