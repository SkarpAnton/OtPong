package pong.game;

public class AI {

    private int y = Field.getHEIGHT() / 2;
    private final Ball ball;

    public AI(Ball ball) {
        this.ball = ball;
    }

    public void move() {

        if (ball.getY() - Paddle.getHEIGHT() / 2 > y
                && y < Field.getHEIGHT() - Paddle.getHEIGHT()) {
            y += 4;
        } else if (ball.getY() - Paddle.getHEIGHT() / 2 < y && y > 0) {
            y -= 4;
        }
    }

    public int getY() {
        return y;
    }

}
