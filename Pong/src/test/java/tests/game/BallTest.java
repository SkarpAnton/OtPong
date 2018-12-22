package tests.game;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import pong.game.Ball;
import pong.game.Field;
import pong.game.Paddle;

public class BallTest {

    private Ball ball;

    public BallTest() {
    }

    @Before
    public void setUp() {
        ball = new Ball(8);
    }

    @Test
    public void yDoesNotGoOverBorder() {
        for (int i = 0; i < 10000; i++) {
            ball.move(0, 0);
            assertTrue(ball.getY() >= 0);
            assertTrue(ball.getY() <= Field.getHEIGHT());
        }
    }

    @Test
    public void moveWorks() {
        int previousX = ball.getX();
        ball.move(0, 0);
        assertTrue(previousX != ball.getX());
    }

    @Test
    public void newStartResetsX() {
        ball.move(0, 0);
        ball.newStart();
        assertEquals(Field.getWIDTH() / 2, ball.getX());
    }

    @Test
    public void newStartRandomY() {
        Boolean yIsConstant = false;
        int previousY = ball.getY();
        for (int i = 0; i < 10; i++) {
            ball.newStart();
            yIsConstant = previousY == ball.getY();
            if (yIsConstant) {
                break;
            }
        }
        assertTrue(!yIsConstant);
    }

    @Test
    public void startsInRandomDirection() {
        Boolean changedDirection = false;
        int xBefore = ball.getX();
        ball.move(Field.getHEIGHT() / 2, Field.getHEIGHT() / 2);
        int xAfter = ball.getX();
        int direction = xAfter - xBefore;
        for (int i = 0; i < 50; i++) {
            ball = new Ball(8);
            xBefore = ball.getX();
            ball.move(Field.getHEIGHT() / 2, Field.getHEIGHT() / 2);
            xAfter = ball.getX();
            int newDirection = xAfter - xBefore;
            changedDirection = direction * newDirection < 0;
            if (changedDirection) {
                break;
            }
        }
        assertTrue(changedDirection);
    }

    @Test
    public void hitsUpperPartOfPaddle() {

        boolean hit = false;
        int xBefore = ball.getX();
        ball.move(Field.getHEIGHT() / 2, Field.getHEIGHT() / 2);
        int xAfter = ball.getX();
        int direction = xAfter - xBefore;

        for (int j = 0; j < 450; j++) {
            xBefore = ball.getX();
            ball.move(ball.getY(), ball.getY());
            xAfter = ball.getX();
            int newDirection = xAfter - xBefore;
            hit = direction * newDirection < 0;
            if (hit) {
                break;
            }
        }

        assertTrue(hit);
    }

    @Test
    public void hitsUpperPartOfPaddleChangesDirection() {

        int xBefore = ball.getX();
        ball.move(Field.getHEIGHT() / 2, Field.getHEIGHT() / 2);
        int xAfter = ball.getX();
        int direction = xAfter - xBefore;

        for (int j = 0; j < 450; j++) {
            xBefore = ball.getX();
            ball.move(ball.getY(), ball.getY());
            xAfter = ball.getX();
            int newDirection = xAfter - xBefore;

            if (direction * newDirection < 0) {
                break;
            }
        }
        int yBefore = ball.getY();
        ball.move(0, 0);
        int yAfter = ball.getY();
        assertTrue(yAfter < yBefore);
    }

    @Test
    public void hitsLowerPartOfPaddleChangesDirection() {

        int xBefore = ball.getX();
        ball.move(Field.getHEIGHT() / 2, Field.getHEIGHT() / 2);
        int xAfter = ball.getX();
        int direction = xAfter - xBefore;

        for (int j = 0; j < 450; j++) {
            xBefore = ball.getX();
            ball.move(ball.getY() - Paddle.getHEIGHT() + 5,
                    ball.getY() - Paddle.getHEIGHT() + 5);
            xAfter = ball.getX();
            int newDirection = xAfter - xBefore;

            if (direction * newDirection < 0) {
                break;
            }
        }
        int yBefore = ball.getY();
        ball.move(0, 0);
        int yAfter = ball.getY();
        assertTrue(yAfter > yBefore);
    }

    @Test
    public void hitsLowerPartOfPaddle() {

        boolean hit = false;
        int xBefore = ball.getX();
        ball.move(Field.getHEIGHT() / 2, Field.getHEIGHT() / 2);
        int xAfter = ball.getX();
        int direction = xAfter - xBefore;

        for (int j = 0; j < 450; j++) {
            xBefore = ball.getX();
            ball.move(ball.getY() - Paddle.getHEIGHT() + 5,
                    ball.getY() - Paddle.getHEIGHT() + 5);
            xAfter = ball.getX();
            int newDirection = xAfter - xBefore;
            hit = direction * newDirection < 0;
            if (hit) {
                break;
            }
        }

        assertTrue(hit);
    }
}
