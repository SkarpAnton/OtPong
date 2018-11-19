package pong;

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
        int paddleHeight = 80;
        int paddleWidth = 20;
        int distanceFromWall = 100;
        graphics.setColor(Color.white);
        graphics.fillRect(Math.abs(x - distanceFromWall), y, paddleWidth, paddleHeight);
    }

    public void drawMiddleLine(int middle, int height) {
        int lineLength = 20;
        for (int i = 0; i < height / lineLength; i += 2) {
            graphics.drawLine(middle, i * lineLength, middle, i * lineLength + lineLength);
        }
    }

    public void drawScore(int playerOne, int playerTwo) {
        graphics.setColor(Color.white);
        int fontSize = 50;
        graphics.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        int xPlayerOne = 400;
        int xPlayerTwo = 700;
        int yPlayers = 50;
        graphics.drawString("P1: " + playerOne, xPlayerOne, yPlayers);
        graphics.drawString("P2: " + playerTwo, xPlayerTwo, yPlayers);
    }
}
