package pong.ui.game;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pong.game.Ball;
import pong.game.Field;
import pong.game.Paddle;

public class GameElements {

    private Rectangle paddleP1;
    private Rectangle paddleP2;
    private Circle ballElement;
    private Text p1ScoreText;
    private Text p2ScoreText;

    public Pane createGameRoot() {
        initializeElements();
        return createPane();
    }

    private void initializeElements() {
        initializeBallElement();
        initializePaddles();
        initializeScoreElements();

    }

    private void initializeScoreElements() {
        initializeP1Score();
        initializeP2Score();
    }

    private void initializeP1Score() {
        p1ScoreText = new Text();
        p1ScoreText.setFont(Font.font("Verdana", 50));
        p1ScoreText.setFill(Color.WHITE);
        p1ScoreText.setX(400);
        p1ScoreText.setY(50);
    }

    private void initializeP2Score() {
        p2ScoreText = new Text();
        p2ScoreText.setFont(Font.font("Verdana", 50));
        p2ScoreText.setFill(Color.WHITE);
        p2ScoreText.setX(700);
        p2ScoreText.setY(50);
    }

    private void initializeBallElement() {
        ballElement = new Circle();
        ballElement.setFill(Color.WHITE);
        ballElement.setRadius(Ball.getBallDiameter());
    }

    private void initializePaddles() {
        initializePaddleP1();
        initializePaddleP2();
    }

    private void initializePaddleP1() {
        paddleP1 = new Rectangle(Paddle.getWIDTH(), Paddle.getHEIGHT());
        paddleP1.setFill(Color.WHITE);
        paddleP1.setX(100);
    }

    private void initializePaddleP2() {
        paddleP2 = new Rectangle(Paddle.getWIDTH(), Paddle.getHEIGHT());
        paddleP2.setFill(Color.WHITE);
        paddleP2.setX(Field.getWIDTH() - 100);
    }

    private Pane createPane() {
        Pane root = new Pane();
        root.getStyleClass().add("pane");
        root.getChildren().add(paddleP1);
        root.getChildren().add(paddleP2);
        root.getChildren().add(ballElement);
        root.getChildren().add(p1ScoreText);
        root.getChildren().add(p2ScoreText);
        return root;
    }

    public Rectangle getPaddleP1() {
        return paddleP1;
    }

    public Rectangle getPaddleP2() {
        return paddleP2;
    }

    public Circle getBallElement() {
        return ballElement;
    }

    public Text getP1ScoreText() {
        return p1ScoreText;
    }

    public Text getP2ScoreText() {
        return p2ScoreText;
    }

}
