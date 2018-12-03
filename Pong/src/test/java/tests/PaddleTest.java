package tests;


import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import pong.game.User;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pong.game.Paddle;

public class PaddleTest {

    private User paddle;
    private final int frameHeight = 800;

    @Before
    public void setUp() {
        paddle = new User(KeyCode.W, KeyCode.S);
    }

    @Test
    public void heightInitializesCorrectly() {
        assertEquals(frameHeight / 2, paddle.getUpdatedHeight());
    }

    @Test
    public void directionInitializesCorrectly() {
        assertEquals(0, paddle.getPadelDirection());
    }

    @Test
    public void moveUpThenUpdateGivesCorrectResult() {
        paddle.move(KeyCode.W);
        assertEquals(frameHeight / 2 - 4, paddle.getUpdatedHeight());
    }

    @Test
    public void moveDownThenUpdateGivesCorrectResult() {
        paddle.move(KeyCode.S);
        assertEquals(frameHeight / 2 + 4, paddle.getUpdatedHeight());
    }

    @Test
    public void canNotGoOverTheUpperBorder() {
        for (int i = 0; i < frameHeight / 2; i++) {
            paddle.move(KeyCode.W);
            paddle.getUpdatedHeight();
        }
        assertEquals(0, paddle.getUpdatedHeight());
    }

    @Test
    public void canNotGoOverTheLowerBorder() {
        for (int i = 0; i < frameHeight / 2; i++) {
            paddle.move(KeyCode.S);
            paddle.getUpdatedHeight();
        }
        assertEquals(frameHeight - Paddle.getHEIGHT(), paddle.getUpdatedHeight());
    }

    @Test
    public void stopsIfGoingUp() {
        paddle.move(KeyCode.W);
        paddle.stop(KeyCode.W);
        assertEquals(frameHeight / 2, paddle.getUpdatedHeight());
    }

    @Test
    public void stopsIfGoingDown() {
        paddle.move(KeyCode.S);
        paddle.stop(KeyCode.S);
        assertEquals(frameHeight / 2, paddle.getUpdatedHeight());
    }

    @Test
    public void doesNotStopIfOtherKeyPressed() {
        paddle.move(KeyCode.S);
        paddle.stop(KeyCode.W);
        assertEquals(frameHeight / 2 + 4, paddle.getUpdatedHeight());
    }

    @Test
    public void paddleDirectionUpWorks() {
        paddle.move(KeyCode.W);
        assertEquals(-1, paddle.getPadelDirection());
    }

    @Test
    public void paddleDirectionDownWorks() {
        paddle.move(KeyCode.S);
        assertEquals(1, paddle.getPadelDirection());
    }

    @Test
    public void paddleNoDirectionWorks() {
        paddle.move(KeyCode.S);
        paddle.stop(KeyCode.S);
        assertEquals(0, paddle.getPadelDirection());
    }
}
