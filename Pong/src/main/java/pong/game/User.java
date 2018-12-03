package pong.game;

import javafx.scene.input.KeyCode;

public class User {

    private final KeyCode upKey;
    private final KeyCode downKey;
    private int y;
    private Direction direction = Direction.NO_DIRECTION;

    public User(KeyCode upKey, KeyCode downKey) {
        this.upKey = upKey;
        this.downKey = downKey;
        y = Field.getHEIGHT() / 2;
    }

    public int getUpdatedHeight() {
        if (y < Field.getHEIGHT() - Paddle.getHEIGHT() && direction == Direction.DOWN) {
            y += 4;
        }
        if (y >= 2 && direction == Direction.UP) {
            y -= 4;
        }
        return y;
    }

    public void move(KeyCode key) {
        if (key == upKey) {
            direction = Direction.UP;
        }
        if (key == downKey) {
            direction = Direction.DOWN;
        }
    }

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
