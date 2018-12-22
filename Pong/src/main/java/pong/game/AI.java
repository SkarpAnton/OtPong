package pong.game;

/**
 * Simple AI for the game Pong
 *
 */
public class AI {

    private int y = Field.getHEIGHT() / 2;
    private final Ball ball;
    private final int ballSpeedMultiplier;

    /**
     * @param ball used to move the paddle where the Ball is located
     * @param ballSpeed speed of the ball, used to calculate paddles speed.
     */
    public AI(Ball ball, int ballSpeed) {
        this.ball = ball;
        ballSpeedMultiplier = ballSpeed / 6 + 1;
    }

    /**
     * Moves the paddle according to what y value ball has. The paddle tries to
     * move the paddles center point to the balls center point. Paddles speed
     * depends on how close the paddle is to the ball, this is done to counter
     * previous versions jitter. Paddle speed also correlates with balls speed
     * to make AI possible to beat even with slower speeds.
     */
    public void move() {
        int middlePoint = y + Paddle.getHEIGHT() / 2;
        int diff = Math.abs(middlePoint - ball.getY());
        if (ball.getY() > middlePoint
                && y < Field.getHEIGHT() - Paddle.getHEIGHT()) {
            y += calculateSpeedOfPaddle(diff);
        } else if (ball.getY() < middlePoint && y > 0) {
            y -= calculateSpeedOfPaddle(diff);
        }
    }

    private int calculateSpeedOfPaddle(double diff) {
        return (int) (ballSpeedMultiplier * Math.min(diff / 50, 2) + 1);
    }

    public int getY() {
        return y;
    }

}
