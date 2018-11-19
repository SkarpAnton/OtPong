package pong;

public class Paddle {

    int upKey;
    int downKey;
    int frameHeight = 800;
    private int y;
    private Direction direction = Direction.NO_DIRECTION;
    private final int paddleHeight = 80;

    public Paddle(int upKey, int downKey) {
        this.upKey = upKey;
        this.downKey = downKey;
        y = frameHeight / 2;
    }

    public int getUpdatedHeight() {
        if (y < frameHeight - paddleHeight - 20 && direction == Direction.DOWN) {
            y += 2;
        }
        if (y >= 2 && direction == Direction.UP) {
            y -= 2;
        }
        return y;
    }

    public void move(int key) {
        if (key == upKey) {
            direction = Direction.UP;
        }
        if (key == downKey) {
            direction = Direction.DOWN;
        }
    }

    public void stop(int key) {
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
