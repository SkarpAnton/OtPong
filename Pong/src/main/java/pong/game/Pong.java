package pong.game;

import javafx.scene.input.KeyCode;

public class Pong {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private final User playerOne = new User(KeyCode.W, KeyCode.S);
    private final User playerTwo = new User(KeyCode.UP, KeyCode.DOWN);
    private final Ball ball;
    private final AI ai;

    public Pong(int ballSpeed) {
        ball = new Ball(ballSpeed);
        ai = new AI(ball);
    }

    public Ball getBall() {
        return ball;
    }

    public User getPlayerOne() {
        return playerOne;
    }

    public User getPlayerTwo() {
        return playerTwo;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void scored() {
        if (ball.getX() <= 0) {
            playerTwoScore++;
            ball.newStart();
        }
        if (ball.getX() >= Field.getWIDTH()) {
            playerOneScore++;
            ball.newStart();
        }
    }

    public boolean isPlayerOneWinner() {
        return playerOneScore >= 11;
    }

    public boolean isPlayerTwoWinner() {
        return playerTwoScore >= 11;
    }

    public boolean hasGameEnded() {
        return isPlayerOneWinner() || isPlayerTwoWinner();
    }

    public AI getAi() {
        return ai;
    }

}
