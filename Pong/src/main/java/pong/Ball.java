package pong;

import java.util.Random;

public class Ball {

    private final Random rand = new Random();
    private int startingDirection = 1;
    private int timeFromHit = 30;
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private final static int BALL_RADIUS = 12;
    private double overAllSpeed;
    private double ySpeed;
    private double xSpeed;
    private double x;
    private double y;
    
    
    public Ball() {
        newStart();
    }

    public void move(int playerOneY, int playerTwoY, int playerOneSpeed,
            int playerTwoSpeed) {
        x += xSpeed;
        y += ySpeed;
        timeFromHit ++;
       
        if (collidesWithSide()) {
            ySpeed = -ySpeed;
        }
        if (collidesWithLeftPaddel(playerOneY)) {
            collision(playerOneY);
            xSpeed = overAllSpeed - Math.abs(ySpeed);
        }
        if (collidesWithRightPaddel(playerTwoY)) {
            collision(playerTwoY);
            xSpeed = -(overAllSpeed - Math.abs(ySpeed));
        }
    }
    
    public void scored() {
        if (x <= 0) {
            playerTwoScore++;
            startingDirection = 1;
            newStart();
        }
        if (x >= Field.getWIDTH()) {
            playerOneScore++;
            startingDirection = -1;
            newStart();
        }
    }

    private void newStart() {
        
        x = Field.getWIDTH() / 2;
        y = rand.nextInt(Field.getHEIGHT() - 100) + 50;
        ySpeed = rand.nextInt(3) - 1;
        overAllSpeed = 6;      
        xSpeed = startingDirection * (overAllSpeed - Math.abs(ySpeed));
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }
    private boolean collidesWithSide() {
        return y >= Field.getHEIGHT() - BALL_RADIUS || y <= BALL_RADIUS;
    }
    private boolean collidesWithLeftPaddel(int playerOneY) {
        return x <= 120 && x >= 110 && y >= playerOneY - BALL_RADIUS &&
                y <= playerOneY + Paddle.getPADDLE_HEIGHT() &&
                timeFromHit > 2;
    }

    private boolean collidesWithRightPaddel(int playerTwoY) {
        return x >= Field.getWIDTH() - 120 && x <= Field.getWIDTH() - 110 &&
                y >= playerTwoY - BALL_RADIUS && y <= playerTwoY + Paddle.getPADDLE_HEIGHT() &&
                timeFromHit > 2;
    }

    private void collision(int playerY) {
        overAllSpeed = overAllSpeed + 0.1;
        if(Math.abs(ySpeed) < 4) {
            ySpeed = ySpeedChangeDueToPositionOfHit(playerY);
        }
        timeFromHit = 0;
    }

    private int ySpeedChangeDueToPositionOfHit(int playerY) {
        double positionOfHit = y - playerY;
        int yChange = -2;
        for (int i = 0; i <= 100; i += 20, yChange ++) {
            if (positionOfHit < i) {
                return yChange;
            }
        }
        return 0;
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

    public static int getBALL_DIAMETER() {
        return BALL_RADIUS;
    }
    

}
