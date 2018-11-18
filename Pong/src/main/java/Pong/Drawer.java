
package Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Drawer {
    private final Graphics graphics;
    
    public Drawer(Graphics graphics) {
        this.graphics = graphics;
    }
    
    public void drawBall(int x, int y) {
        int size = 20;
        graphics.setColor(Color.white);
        graphics.fillOval(x - size / 2, y, size, size);
    }
    
    public void drawPaddle(int x, int y) {
        int height = 80;
        int width = 20;
        graphics.setColor(Color.white);
        graphics.fillRect(x, y, width, height);
    }
    
    public void drawMiddleLine(int middle, int height) {
        int lineLength = 20;
        for(int i = 0; i < height / lineLength; i += 2) {
            graphics.drawLine(middle, i * lineLength, middle, i * lineLength + lineLength);
        }
    }
    
    public void addScore(int playerOne, int playerTwo) {
        graphics.setColor(Color.white);
        graphics.setFont(new Font("TimesRoman", Font.PLAIN, 50)); 
        graphics.drawString("P1: " + playerOne, 400, 50);
        graphics.drawString("P2: " + playerTwo, 700, 50);
    }
}
