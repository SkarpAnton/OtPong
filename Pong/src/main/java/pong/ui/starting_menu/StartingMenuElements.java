package pong.ui.starting_menu;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pong.game.Field;
import pong.ui.MenuBox;

public class StartingMenuElements {

    private Text title;
    private MenuBox menu;

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
        menu = new MenuBox();
        menu.addTextElement(new Text("One player"));
        menu.addTextElement(new Text("Two Player"));
        menu.addTextElement(new Text("Exit"));
    }

    public MenuBox getMenu() {
        return menu;
    }

    public Text getTitle() {
        return title;
    }

}
