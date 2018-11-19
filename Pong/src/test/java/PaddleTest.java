
import pong.Paddle;
import java.awt.event.KeyEvent;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaddleTest {

    private Paddle paddle;
    private final int frameHeight = 800;

    @Before
    public void setUp() {
        paddle = new Paddle(KeyEvent.VK_W, KeyEvent.VK_S);
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
        paddle.move(KeyEvent.VK_W);
        assertEquals(frameHeight / 2 - 2, paddle.getUpdatedHeight());
    }

    @Test
    public void moveDownThenUpdateGivesCorrectResult() {
        paddle.move(KeyEvent.VK_S);
        assertEquals(frameHeight / 2 + 2, paddle.getUpdatedHeight());
    }

    @Test
    public void canNotGoOverTheUpperBorder() {
        for (int i = 0; i < frameHeight / 2; i++) {
            paddle.move(KeyEvent.VK_W);
            paddle.getUpdatedHeight();
        }
        assertEquals(0, paddle.getUpdatedHeight());
    }

    @Test
    public void canNotGoOverTheLowerBorder() {
        for (int i = 0; i < frameHeight / 2; i++) {
            paddle.move(KeyEvent.VK_S);
            paddle.getUpdatedHeight();
        }
        assertEquals(frameHeight - 100, paddle.getUpdatedHeight());
    }

    @Test
    public void stopsIfGoingUp() {
        paddle.move(KeyEvent.VK_W);
        paddle.stop(KeyEvent.VK_W);
        assertEquals(frameHeight / 2, paddle.getUpdatedHeight());
    }

    @Test
    public void stopsIfGoingDown() {
        paddle.move(KeyEvent.VK_S);
        paddle.stop(KeyEvent.VK_S);
        assertEquals(frameHeight / 2, paddle.getUpdatedHeight());
    }

    @Test
    public void doesNotStopIfOtherKeyPressed() {
        paddle.move(KeyEvent.VK_S);
        paddle.stop(KeyEvent.VK_W);
        assertEquals(frameHeight / 2 + 2, paddle.getUpdatedHeight());
    }

    @Test
    public void paddleDirectionUpWorks() {
        paddle.move(KeyEvent.VK_W);
        assertEquals(-1, paddle.getPadelDirection());
    }

    @Test
    public void paddleDirectionDownWorks() {
        paddle.move(KeyEvent.VK_S);
        assertEquals(1, paddle.getPadelDirection());
    }

    @Test
    public void paddleNoDirectionWorks() {
        paddle.move(KeyEvent.VK_S);
        paddle.stop(KeyEvent.VK_S);
        assertEquals(0, paddle.getPadelDirection());
    }
}
