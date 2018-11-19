package pong;

import java.util.Random;

public class Ball {

    private final Random rand = new Random();
    private final int fieldWidth = 1200;
    private final int fieldHeight = 800;
    private int startingDirection = 1;
    private int xSpeed = 4;
    private int ySpeed = rand.nextInt(6) - 3;
    private int x = fieldWidth / 2;
    private int y = rand.nextInt(fieldHeight);
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private final int ballDiameter = 40;
    private final int paddleHeight = 80;

    public void move(int playerOneY, int playerTwoY, int playerOneSpeed,
            int playerTwoSpeed) {
        x += xSpeed;
        y += ySpeed;
        if (y >= fieldHeight - ballDiameter || y <= 0) {
            ySpeed = -ySpeed;
        }
        if (collidesWithLeftPaddel(playerOneY)) {
            xSpeed = -xSpeed;
            ySpeed += playerOneSpeed;
        }
        if (collidesWithRightPaddel(playerTwoY)) {
            xSpeed = -xSpeed;
            ySpeed += playerTwoSpeed;
        }
    }

    public void scored() {
        if (x <= 0) {
            playerTwoScore++;
            startingDirection = 1;
            newStart();
        }
        if (x >= fieldWidth) {
            playerOneScore++;
            startingDirection = -1;
            newStart();
        }
    }

    private void newStart() {
        x = fieldWidth / 2;
        y = rand.nextInt(fieldHeight);
        ySpeed = rand.nextInt(6) - 3;
        xSpeed = startingDirection * 3;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    private boolean collidesWithLeftPaddel(int playerOneY) {
        return x <= 120 && x >= 115 && y >= playerOneY - ballDiameter
                && y <= playerOneY + paddleHeight;
    }

    private boolean collidesWithRightPaddel(int playerTwoY) {
        return x >= fieldWidth - 120 && x <= fieldWidth - 110
                && y >= playerTwoY - ballDiameter && y <= playerTwoY + paddleHeight;
    }

}
