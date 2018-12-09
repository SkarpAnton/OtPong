package pong.ui.menu.starting;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pong.game.Field;
import pong.ui.menu.MenuElements;

public class StartingMenuElements extends MenuElements {

    private Text title;

    public StartingMenuElements() {
        initializeTitle();
        initializeMenu();
    }

    private void initializeTitle() {
        title = new Text("Fake Pong");
        title.setFont(Font.font("Verdana", 100));
        title.setFill(Color.WHITE);
        title.setX(Field.getWIDTH() / 2 - 250);
        title.setY(100);
    }

    private void initializeMenu() {
        this.addTextElement(new Text("One player"));
        this.addTextElement(new Text("Two Player"));
        this.addTextElement(new Text("Ranked"));
        this.addTextElement(new Text("Exit"));
    }

    public Text getTitle() {
        return title;
    }

}
