package pong.ui.menu.endgame;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pong.ui.menu.MenuElements;

public class GameEndElements extends MenuElements {

    private Text score;
    private Text winText;
    private Text instruction;

    public GameEndElements(int playerOneScore, int playerTwoScore, String winner) {
        initializeWinText(winner);
        intializeScore(playerOneScore, playerTwoScore);
        initializeInstruction();

    }

    private void intializeScore(int playerOneScore, int playerTwoScore) {
        score = new Text("P1: " + playerOneScore + "     -----     P2: " + playerTwoScore);
        score.setFill(Color.WHITE);
        score.setFont(Font.font("Verdana", 70));
        score.setX(200);
        score.setY(350);
    }

    private void initializeWinText(String winner) {
        winText = new Text(winner + " won");
        winText.setFill(Color.WHITE);
        winText.setFont(Font.font("Verdana", 100));
        winText.setX(200);
        winText.setY(200);
    }

    private void initializeInstruction() {
        instruction = new Text("Press enter to go to menu");
        instruction.setFill(Color.WHITE);
        instruction.setFont(Font.font("Verdana", 50));
        instruction.setX(240);
        instruction.setY(600);
    }

    public Text getInstruction() {
        return instruction;
    }

    public Text getScore() {
        return score;
    }

    public Text getWinText() {
        return winText;
    }

}
