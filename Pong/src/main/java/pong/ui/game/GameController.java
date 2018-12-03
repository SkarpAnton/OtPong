package pong.ui.game;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pong.game.Field;
import pong.game.Pong;

public class GameController {

    private final Pong pong;
    private final GameElements elements;
    private final Pane root;
    private final Scene scene;
    private final Boolean twoPlayerGame;
    private final Stage stage;

    public GameController(Boolean twoPlayerGame, int ballSpeed, Stage stage) {
        this.stage = stage;
        this.twoPlayerGame = twoPlayerGame;
        pong = new Pong(ballSpeed, twoPlayerGame);
        elements = new GameElements();
        root = elements.createGameRoot();
        scene = new Scene(root, Field.getWIDTH(), Field.getHEIGHT());
        scene.getStylesheets().add("paneStyle.css");
        setKeyEventsToScene();
        startTimer();
    }

    public Scene getScene() {
        return scene;
    }

    private void setKeyEventsToScene() {
        scene.setOnKeyPressed((KeyEvent e) -> {
            pong.getPlayerOne().move(e.getCode());
            pong.getPlayerTwo().move(e.getCode());

        });

        scene.setOnKeyReleased((KeyEvent e) -> {
            pong.getPlayerOne().stop(e.getCode());
            pong.getPlayerTwo().stop(e.getCode());
        });
    }

    private void startTimer() {
        new AnimationTimer() {
            @Override
            public void handle(long currentNanoTime) {
                pong.move();
                elements.getPaddleP1().setY(pong.getPlayerOne().getUpdatedHeight());
                if (twoPlayerGame) {
                    elements.getPaddleP2().setY(pong.getPlayerTwo().getUpdatedHeight());
                } else {
                    elements.getPaddleP2().setY(pong.getAi().getY());
                }
                updateBall();
                updateScore();
            }
        }.start();
    }
    
    private void updateBall() {
        elements.getBallElement().setCenterX(pong.getBall().getX());
        elements.getBallElement().setCenterY(pong.getBall().getY());
    }

    private void updateScore() {
        pong.scored();
        elements.getP1ScoreText().setText("P1: " + pong.getPlayerOneScore());
        elements.getP2ScoreText().setText("P2: " + pong.getPlayerTwoScore());
    }

   

}
