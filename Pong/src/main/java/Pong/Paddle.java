
package Pong;


import java.awt.event.KeyEvent;


public class Paddle {
    public enum Direction {UP, NO_DIRECTION, DOWN};
    int upKey;
    int downKey;
    int height;
    private int y = 400;
    private Direction direction = Direction.NO_DIRECTION;
    private int paddleHeight;
    
    public Paddle(int upKey, int downKey, int height, int paddleHeight) {
        this.upKey = upKey;
        this.downKey = downKey;
        this.height = height;
        this.paddleHeight = paddleHeight;
    }

    public int getUpdatedHeight() {
        if(y < height - paddleHeight - 20 && direction == Direction.DOWN) y += 2;
        if(y >= 0 && direction == Direction.UP) y -= 2;
        return y;
    }


    public void move(KeyEvent key) {
        if(key.getKeyCode() == upKey) direction = Direction.UP;
        if(key.getKeyCode() == downKey) direction = Direction.DOWN;
    }

    public void stop(KeyEvent key) {
        if(key.getKeyCode() == upKey || key.getKeyCode() == downKey)
            direction = Direction.NO_DIRECTION;
    }
    
    public int getPadelDirection() {
        switch (direction) {
            case DOWN: return 1;
            case UP: return -1;
            default: return 0;
        }
    }
}
