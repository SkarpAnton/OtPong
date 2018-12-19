
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
    public void AIFollowsBallTest() {
        for (int i = 0; i < 1000; i ++) {
            ball.move(-1, -1);
            int currentYDiff = Math.abs(ball.getY() - ai.getY());
            ai.move();
            int newYDiff = Math.abs(ball.getY() - ai.getY());
            if (ball.getY() > Paddle.getHEIGHT() / 2 
                    && ball.getY() < Field.getHEIGHT() - Paddle.getHEIGHT() / 2) {
                assertTrue(newYDiff <= currentYDiff || currentYDiff <= 2);
            }
        }
    }
}
