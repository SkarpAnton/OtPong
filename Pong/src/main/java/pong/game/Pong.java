package pong.game;

import javafx.scene.input.KeyCode;

public class Pong {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private final User playerOne = new User(KeyCode.W, KeyCode.S);
    private final User playerTwo = new User(KeyCode.UP, KeyCode.DOWN);
    private final Boolean twoPlayerGame;
    private final Ball ball;
    private final AI ai;

    public Pong(int ballSpeed, boolean twoPlayers) {
        this.twoPlayerGame = twoPlayers;
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
    
    public void move() {
        if (twoPlayerGame) {
            ball.move(playerOne.getUpdatedHeight(), playerTwo.getUpdatedHeight());
        } else {
            ai.move();
            ball.move(playerOne.getUpdatedHeight(), ai.getY());
        }
        
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
