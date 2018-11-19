package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener, KeyListener {

    private final int heightOfFrame = 800;
    private final int widthOfFrame = 1200;
    private final Paddle playerOne;
    private final Paddle playerTwo;
    Ball ball = new Ball();

    public Panel() {
        Timer timer = new Timer(5, this);
        timer.start();
        playerOne = new Paddle(KeyEvent.VK_W, KeyEvent.VK_S);
        playerTwo = new Paddle(KeyEvent.VK_UP, KeyEvent.VK_DOWN);
        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        setBackground(Color.black);
        Drawer drawer = new Drawer(graphics);
        drawer.drawBall(ball.getX(), ball.getY());
        drawer.drawPaddle(0, playerOne.getUpdatedHeight());
        drawer.drawPaddle(widthOfFrame, playerTwo.getUpdatedHeight());
        drawer.drawMiddleLine(widthOfFrame / 2, heightOfFrame);
        drawer.drawScore(ball.getPlayerOneScore(), ball.getPlayerTwoScore());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ball.move(playerOne.getUpdatedHeight(), playerTwo.getUpdatedHeight(),
                playerOne.getPadelDirection(), playerTwo.getPadelDirection());
        ball.scored();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        playerOne.move(ke.getKeyCode());
        playerTwo.move(ke.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        playerOne.stop(ke.getKeyCode());
        playerTwo.stop(ke.getKeyCode());
    }

}
