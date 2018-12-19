package pong.game;

import java.util.Random;

/**
 * Ball for the game pong
 */

public class Ball {

    private final static int BALL_RADIUS = 12;
    private final Random rand = new Random();
    private int direction = rand.nextBoolean() ? 1 : -1;
    private int timeFromHit = 30;
    private final double ballSpeed;
    private double ySpeed;
    private double xSpeed;
    private double x;
    private double y;
    
    public Ball(int ballSpeed) {
        this.ballSpeed = ballSpeed;
        newStart();
    }
    
    /**
     * Moves the ball. Bounces of paddles and upper and lower side of the field.
     * Fields side simply negates balls vertical momentum. Bounce from
     * the paddle is calculated based on the position of the hit relative to paddle.
     * @param playerOneY height of the middle of  the player one's paddle (y coordinate)
     * @param playerTwoY height of the middle of  the player two's paddle (y coordinate)
     */
    public void move(int playerOneY, int playerTwoY) {
        x += xSpeed;
        y += ySpeed;
        timeFromHit++;

        if (collidesWithSide()) {
            ySpeed = -ySpeed;
        }
        if (collidesWithLeftPaddel(playerOneY)) {
            collision(playerOneY);
            xSpeed = ballSpeed - Math.abs(ySpeed);
        }
        if (collidesWithRightPaddel(playerTwoY)) {
            collision(playerTwoY);
            xSpeed = -(ballSpeed - Math.abs(ySpeed));
        }
    }
    
    /**
     * Sets values for the new start
     */
    public void newStart() {
        x = Field.getWIDTH() / 2;
        y = rand.nextInt(Field.getHEIGHT() - 100) + 50;
        ySpeed = rand.nextInt(7) - 3;
        direction *= -1;
        xSpeed = direction * (ballSpeed - Math.abs(ySpeed));
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    private boolean collidesWithSide() {
        return y >= Field.getHEIGHT() - BALL_RADIUS || y <= BALL_RADIUS;
    }

    private boolean collidesWithLeftPaddel(int playerOneY) {
        return x <= 120 && x >= 105 && y >= playerOneY - BALL_RADIUS
                && y <= playerOneY + Paddle.getHEIGHT()
                && timeFromHit > 5;
    }

    private boolean collidesWithRightPaddel(int playerTwoY) {
        return x >= Field.getWIDTH() - 120 && x <= Field.getWIDTH() - 105
                && y >= playerTwoY - BALL_RADIUS && y <= playerTwoY + Paddle.getHEIGHT()
                && timeFromHit > 5;
    }

    private void collision(int playerY) {
        direction *= -1;
        ySpeed = ySpeedChangeDueToPositionOfHit(playerY);
        timeFromHit = 0;
    }

    private double ySpeedChangeDueToPositionOfHit(int playerY) {
        double positionOfHit = y - playerY;
        double yChange = -ballSpeed / 2;
        for (int i = 0; i <= 100; i += 100 / 7, yChange += ballSpeed / 7) {
            if (positionOfHit < i) {
                return yChange;
            }
        }
        return 0;
    }

    public static int getBallDiameter() {
        return BALL_RADIUS;
    }

}
