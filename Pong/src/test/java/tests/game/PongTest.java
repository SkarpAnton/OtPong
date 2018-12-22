package tests.game;


import java.sql.Connection;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pong.game.Pong;
import pong.game.Speeds;
import pong.rating.RatingHandler;


public class PongTest {
    
    private Pong pong;
    
    public PongTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {        
        pong = new Pong(Speeds.getNormal(), true, null);
    }
    
    @Test
    public void scoreGoalTest() {
        scoreAGoal();
        pong.scored();
        assertTrue(pong.getPlayerOneScore() == 1 || pong.getPlayerTwoScore() == 1);
    }
    
    @Test
    public void scoringResetsTest() {
        scoreAGoal();
        pong.scored();
        pong.scored();
        assertTrue(pong.getPlayerOneScore() != 2 && pong.getPlayerTwoScore() != 2);
    }
    
    @Test
    public void waitBetweenGamesWorksTest() {
        for (int  i = 0; i < 5; i++) {
            scoreAGoal();
        }
        assertTrue(pong.getPlayerOneScore() <= 1 && pong.getPlayerTwoScore() <= 1);
    }
    
    @Test
    public void gameEndedTest() {
        for (int  i = 0; i < 21; i++) {
            scoreAGoal();
            //used to remove the wait between rounds
            for (int j = 0; j <= 100; j++) {
                pong.scored();
            }
        }
        assertTrue(pong.hasGameEnded());
    }
    
    @Test
    public void gameNotEndedTest() {
        assertTrue(!pong.hasGameEnded());
    }
    
    @Test
    public void gameNotEndedOneGoalTest() {
        scoreAGoal();
        assertTrue(!pong.hasGameEnded());
    }
    
    private void scoreAGoal() {
        for( int i = 0; i < 10000; i++) {
            pong.move();
        }
        pong.scored();
    }
}
