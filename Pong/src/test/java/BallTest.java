/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pong.Ball;

/**
 *
 * @author skarp
 */
public class BallTest {
    private Ball ball;
    
    public BallTest() {
    }
    
    
    @Before
    public void setUp() {
        ball = new Ball();
    }
    
    @Test
    public void moveWorks() {
        int previousX = ball.getX();
        ball.move(0, 0);
        assertTrue(previousX != ball.getX());
    }
    @Test
    public void scoringWorks() {
        int previousScore = ball.getPlayerOneScore();
        for(int i = 0; i < 150; i++) {
            ball.move(-100, -100);
        }
        ball.scored();
        assertTrue(previousScore != ball.getPlayerOneScore());
    }
}
