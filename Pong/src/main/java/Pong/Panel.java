
package Pong;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener, KeyListener{
    private int heightOfFrame;
    private int widthOfFrame;
    private Paddle playerOne;
    private Paddle playerTwo;
    Ball ball = new Ball();
    
    public Panel() {
        Timer timer = new Timer(5, this);
        timer.start();
        playerOne = new Paddle(KeyEvent.VK_W, KeyEvent.VK_S, 800, 80);
        playerTwo = new Paddle(KeyEvent.VK_UP, KeyEvent.VK_DOWN, 800, 80);
        addKeyListener(this);
        setFocusable(true);
    }
    
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        setBackground(Color.black);
        Drawer drawer = new Drawer(graphics);
        drawer.drawBall(ball.getX(), ball.getY()); //temporary coordinates
        drawer.drawPaddle(100, playerOne.getUpdatedHeight());
        drawer.drawPaddle(1100, playerTwo.getUpdatedHeight());
        drawer.drawMiddleLine(600, 800);
        drawer.addScore(ball.getPlayerOneScore(), ball.getPlayerTwoScore());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ball.move(playerOne.getUpdatedHeight(), playerTwo.getUpdatedHeight(),
                playerOne.getPadelDirection(), playerTwo.getPadelDirection());
        ball.scored();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {}

    @Override
    public void keyPressed(KeyEvent ke) {
       playerOne.move(ke);
       playerTwo.move(ke);
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        playerOne.stop(ke);
        playerTwo.stop(ke);
    }
    
}
