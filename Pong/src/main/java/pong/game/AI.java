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
            if(ball.getY() > y) {
                y += 3;
            } 
            y += 1;
        } else if (ball.getY() - Paddle.getHEIGHT() / 2 < y && y > 0) {
            if(ball.getY() < y) {
                y -= 3;
            } 
            y -= 1;
        }
    }

    public int getY() {
        return y;
    }

}
