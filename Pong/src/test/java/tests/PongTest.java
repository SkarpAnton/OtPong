package tests;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pong.game.Pong;
import pong.game.Speeds;


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
        for( int i = 0; i < 10000; i++) {
            pong.move();
        }
        pong.scored();
        assertTrue(pong.getPlayerOneScore() == 1 || pong.getPlayerTwoScore() == 1);
    }
}
