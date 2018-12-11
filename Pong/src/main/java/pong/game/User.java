package pong.game;

import javafx.scene.input.KeyCode;

/**
 * Used to hold logic and data from the user controlled paddle in the game pong
 */
public class User {

    private final KeyCode upKey;
    private final KeyCode downKey;
    private int y = Field.getHEIGHT() / 2;
    private Direction direction = Direction.NO_DIRECTION;

    /**
     * COntructor for the game pong
     * @param upKey key that the user holds to make paddle go down
     * @param downKey key that the user holds to make the paddle go down
     */
    public User(KeyCode upKey, KeyCode downKey) {
        this.upKey = upKey;
        this.downKey = downKey;
    }

    /**
     * Updates the height based on the the direction that the paddle is moving
     * @return return the updated height of the paddle
     */
    public int getUpdatedHeight() {
        if (y < Field.getHEIGHT() - Paddle.getHEIGHT() && direction == Direction.DOWN) {
            y += 4;
        }
        if (y >= 2 && direction == Direction.UP) {
            y -= 4;
        }
        return y;
    }

    /**
     * Sets the direction if the code is either upKey or downKey set on the constructor
     * @param key keycode of the pressed key
     */
    public void move(KeyCode key) {
        if (key == upKey) {
            direction = Direction.UP;
        }
        if (key == downKey) {
            direction = Direction.DOWN;
        }
    }

    /**
     * Changes direction to NO_DIRECTION if the key and direction correspond
     * @param key keycode of the pressed key
     */
    public void stop(KeyCode key) {
        if (key == upKey && Direction.UP == direction) {
            direction = Direction.NO_DIRECTION;
        }
        if (key == downKey && Direction.DOWN == direction) {
            direction = Direction.NO_DIRECTION;
        }
    }

    public int getPadelDirection() {
        switch (direction) {
            case DOWN:
                return 1;
            case UP:
                return -1;
            default:
                return 0;
        }
    }
}
