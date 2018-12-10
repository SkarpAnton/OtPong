package pong.ui.menu.ranked;

import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import pong.database.RatingHandler;
import pong.game.Speeds;
import pong.ui.game.GameController;
import pong.ui.menu.MenuController;

public class RankedController extends MenuController {

    RankedElements rankedElements;

    public RankedController(RankedElements rankedElements) {
        super(rankedElements);
        this.rankedElements = rankedElements;
    }

    @Override
    protected void addAndModifyChildren(Pane root) {
        setKeyPressesOnTextField(rankedElements.getP1TextField());
        setKeyPressesOnTextField(rankedElements.getP2TextField());
        root.getChildren().add(rankedElements.getTextFields());
        root.getChildren().add(rankedElements.getErrorMessage());
        root.getChildren().add(rankedElements.getTitle());
    }

    private void setKeyPressesOnTextField(TextField textField) {
        textField.setOnKeyPressed(event -> {
            action(event);
        });
    }

    @Override
    protected void activate() {
        String playerOneName = rankedElements.getP1TextField().getText();
        String playerTwoName = rankedElements.getP2TextField().getText();
        if (playerOneName.isEmpty() || playerTwoName.isEmpty()) {
            rankedElements.missingName();
        } else if (containsSpecialChars(playerOneName, playerTwoName)) {
            rankedElements.usesSpecialChars();
        } else {
            RatingHandler ranked = new RatingHandler(playerOneName, playerTwoName);
            GameController gameController
                    = new GameController(true, Speeds.getFast(), ranked, stage);
            stage.setScene(gameController.getScene());
        }
    }
    
    private boolean containsSpecialChars(String playerOneName, String playerTwoName) {
        return !playerOneName.matches("[a-zA-Z0-9]*") || 
                !playerTwoName.matches("[a-zA-Z0-9]*");
    }

}
