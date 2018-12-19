package pong.game;

import pong.rating.RatingHandler;
import javafx.scene.input.KeyCode;

/**
 * Contains objects related to the game and some logic
 */
public class Pong {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private final int gamePlayedTo = 11;
    private final User playerOne = new User(KeyCode.W, KeyCode.S);
    private final User playerTwo = new User(KeyCode.UP, KeyCode.DOWN);
    private int countDownFromGoal = 100;
    private final RatingHandler ratingHandler;
    private boolean goalScored;
    private final Boolean twoPlayerGame;
    private final Ball ball;
    private final AI ai;

    public Pong(int ballSpeed, boolean twoPlayers, RatingHandler ratingHandler) {
        this.twoPlayerGame = twoPlayers;
        ball = new Ball(ballSpeed);
        ai = new AI(ball, ballSpeed);
        this.ratingHandler = ratingHandler;
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

    public Boolean isTwoPlayerGame() {
        return twoPlayerGame;
    }

    /**
     * Calls the game objects to move
     */
    public void move() {
        if (twoPlayerGame) {
            ball.move(playerOne.getUpdatedHeight(), playerTwo.getUpdatedHeight());
        } else {
            ai.move();
            ball.move(playerOne.getUpdatedHeight(), ai.getY());
        }

    }
    
  
    public void updateRating() {
        if (ratingHandler != null) {
            ratingHandler.updateRatings(isPlayerOneWinner());
        }
    }

    /**
     * If ball crossed left - or right side increases the opposite players score
     * and starts the countdown for the game to continue after goal
     */
    public void scored() {
        if (ball.getX() <= 0) {
            playerTwoScore = scoreGoal(playerTwoScore);

        }
        if (ball.getX() >= Field.getWIDTH()) {
            playerOneScore = scoreGoal(playerOneScore);
        }
    }

    private int scoreGoal(int playerScore) {
        if (!goalScored) {
            playerScore++;
            goalScored = true;
        } else if (countDownIsDone()) {
            ball.newStart();
            goalScored = false;
        }
        return playerScore;
    }

    private boolean countDownIsDone() {
        if (countDownFromGoal <= 0) {
            countDownFromGoal = 100;
            return true;
        }
        countDownFromGoal--;
        return false;
    }

    /**
     * checks if player one won
     * @return true if player one has 11 or more goals otherwise false
     */
    public boolean isPlayerOneWinner() {
        return playerOneScore >= gamePlayedTo;
    }

    /**
     * checks if player two won
     * @return true if player two has 11 or more goals otherwise false
     */
    public boolean isPlayerTwoWinner() {
        return playerTwoScore >= gamePlayedTo;
    }

    /**
     * Checks if game ended
     * @return true if one side has scored 11 or more goals otherwise return false.
     */
    public boolean hasGameEnded() {
        return isPlayerOneWinner() || isPlayerTwoWinner();
    }

    public AI getAi() {
        return ai;
    }

}
