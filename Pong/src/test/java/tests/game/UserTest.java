package tests.game;

import javafx.scene.input.KeyCode;
import pong.game.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pong.game.Field;
import pong.game.Paddle;

public class UserTest {

    private User user;
    private final int frameHeight = Field.getHEIGHT();

    @Before
    public void setUp() {
        user = new User(KeyCode.W, KeyCode.S);
    }

    @Test
    public void heightInitializesCorrectly() {
        assertEquals(frameHeight / 2, user.getUpdatedHeight());
    }

    @Test
    public void directionInitializesCorrectly() {
        assertEquals(0, user.getPadelDirection());
    }

    @Test
    public void moveUpThenUpdateGivesCorrectResult() {
        user.move(KeyCode.W);
        assertEquals(frameHeight / 2 - 4, user.getUpdatedHeight());
    }

    @Test
    public void moveDownThenUpdateGivesCorrectResult() {
        user.move(KeyCode.S);
        assertEquals(frameHeight / 2 + 4, user.getUpdatedHeight());
    }

    @Test
    public void canNotGoOverTheUpperBorder() {
        for (int i = 0; i < frameHeight / 2; i++) {
            user.move(KeyCode.W);
            user.getUpdatedHeight();
        }
        assertEquals(0, user.getUpdatedHeight());
    }

    @Test
    public void canNotGoOverTheLowerBorder() {
        for (int i = 0; i < frameHeight / 2; i++) {
            user.move(KeyCode.S);
            user.getUpdatedHeight();
        }
        assertEquals(frameHeight - Paddle.getHEIGHT(), user.getUpdatedHeight());
    }

    @Test
    public void stopsIfGoingUp() {
        user.move(KeyCode.W);
        user.stop(KeyCode.W);
        assertEquals(frameHeight / 2, user.getUpdatedHeight());
    }

    @Test
    public void stopsIfGoingDown() {
        user.move(KeyCode.S);
        user.stop(KeyCode.S);
        assertEquals(frameHeight / 2, user.getUpdatedHeight());
    }

    @Test
    public void doesNotStopIfOtherKeyPressed() {
        user.move(KeyCode.S);
        user.stop(KeyCode.W);
        assertEquals(frameHeight / 2 + 4, user.getUpdatedHeight());
    }

    @Test
    public void paddleDirectionUpWorks() {
        user.move(KeyCode.W);
        assertEquals(-1, user.getPadelDirection());
    }

    @Test
    public void paddleDirectionDownWorks() {
        user.move(KeyCode.S);
        assertEquals(1, user.getPadelDirection());
    }

    @Test
    public void paddleNoDirectionWorks() {
        user.move(KeyCode.S);
        user.stop(KeyCode.S);
        assertEquals(0, user.getPadelDirection());
    }
}
