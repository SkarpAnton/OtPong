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
import pong.Field;

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
        int previousP1Score = ball.getPlayerOneScore();
        int previousP2Score = ball.getPlayerTwoScore();
        for(int i = 0; i < 150; i++) {
            ball.move(-100, -100);
        }
        ball.scored();
        assertTrue(previousP1Score != ball.getPlayerOneScore() ||
                previousP2Score != ball.getPlayerTwoScore());
    }
    
    @Test
    public void hitsPaddle() {
        boolean hit = false;
        for(int i = 0; i < 1000; i++) {
            int previousP1Score = ball.getPlayerOneScore();
            int previousP2Score = ball.getPlayerTwoScore();
            for(int j = 0; j < 150; j++) {
                ball.move(Field.getHEIGHT() / 2, Field.getHEIGHT() / 2);
            }
            ball.scored();
            if(previousP1Score == ball.getPlayerOneScore() &&
                previousP2Score == ball.getPlayerTwoScore()) {
                hit = true;
            }
        }
        assertTrue(hit);
    }
}
