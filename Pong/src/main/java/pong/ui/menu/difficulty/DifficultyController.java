package pong.ui.menu.difficulty;

import javafx.scene.layout.Pane;
import pong.game.Speeds;
import pong.ui.menu.MenuController;
import pong.ui.game.GameController;

public class DifficultyController extends MenuController {

    private final Boolean twoPlayergame;

    public DifficultyController(DifficultyElements elements, boolean twoPlayerGame) {
        super(elements);
        this.twoPlayergame = twoPlayerGame;
    }

    @Override
    protected void activate() {
        switch (currentElement) {
            case 0:
                transitionToGame(Speeds.getSlow());
                break;
            case 1:
                transitionToGame(Speeds.getNormal());
                break;
            case 2:
                transitionToGame(Speeds.getFast());
                break;
            case 3:
                transitionToGame(Speeds.getSuperFast());
                break;
        }
    }
   
    private void transitionToGame(int speed) {
        GameController gameController = new GameController(twoPlayergame, speed, null, stage);
        stage.setScene(gameController.getScene());
    }

    @Override
    protected void addAndModifyChildren(Pane root) {
    }

}
