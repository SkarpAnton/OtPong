
package pong;


import javafx.scene.input.KeyCode;

public class Pong {
    private final Ball ball = new Ball();
    private final Paddle playerOne = new Paddle(KeyCode.W, KeyCode.S);
    private final Paddle playerTwo = new Paddle(KeyCode.UP, KeyCode.DOWN);

    public Ball getBall() {
        return ball;
    }

    public Paddle getPlayerOne() {
        return playerOne;
    }

    public Paddle getPlayerTwo() {
        return playerTwo;
    }

}
