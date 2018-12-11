package pong.game;

/**
 *  Simple AI for the game Pong 
 *
 */
public class AI {

    private int y = Field.getHEIGHT() / 2;
    private final Ball ball;
    
    /**
     * Constructor for class AI
     * @param ball used to move the paddle where the Ball is located
     */
    public AI(Ball ball) {
        this.ball = ball;
    }
    
    /**
     * Moves the paddle according to what position the ball. The paddle tries 
     * to move the paddles center point to the balls center point. Paddle moves 
     * slower if it is within y coordinates of the paddle this is used to counter
     * previous versions jitter.
     */
    public void move() {

        if (ball.getY() - Paddle.getHEIGHT() / 2 > y
                && y < Field.getHEIGHT() - Paddle.getHEIGHT()) {
            if (ball.getY() > y) {
                y += 3;
            }
            y += 1;
        } else if (ball.getY() - Paddle.getHEIGHT() / 2 < y && y > 0) {
            if (ball.getY() < y) {
                y -= 3;
            }
            y -= 1;
        }
    }

    public int getY() {
        return y;
    }

}
