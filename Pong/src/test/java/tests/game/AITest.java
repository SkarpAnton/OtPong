package tests.game;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pong.game.AI;
import pong.game.Ball;
import pong.game.Field;
import pong.game.Paddle;
import pong.game.Speeds;

public class AITest {

    private Ball ball;
    private AI ai;

    public AITest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
        ball = new Ball(Speeds.getNormal());
        ai = new AI(ball, Speeds.getNormal());
    }

    @Test
    public void AIDoesNotGoOverBorder() {
        int buffer = 5;
        for (int i = 0; i < 10000; i++) {
            ai.move();
            ball.move(-1, -1);
            assertTrue(ai.getY() <= Field.getHEIGHT() - Paddle.getHEIGHT() + buffer);
            assertTrue(ai.getY() >= -buffer);
        }
    }

    @Test
    public void AIFollowsBallTest() {
        for (int i = 0; i < 1000; i++) {
            ball.move(-1, -1);
            int currentYDiff = difference();
            ai.move();
            int newYDiff = difference();
            if (ball.getY() > Paddle.getHEIGHT() / 2
                    && ball.getY() < Field.getHEIGHT() - Paddle.getHEIGHT() / 2) {                
                assertTrue(newYDiff <= currentYDiff || currentYDiff <= 2);
            }
        }
    }
   
    
    private int difference() {
        return Math.abs(ball.getY() - paddleMiddlePoint());
    }
    
    private int paddleMiddlePoint() {
        return ai.getY() + Paddle.getHEIGHT() / 2;
    }
}
