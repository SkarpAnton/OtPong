package pong.ui.menu;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import pong.game.Field;

public class MenuBox extends VBox {

    private final List<Text> texts = new ArrayList<>();

    public MenuBox() {
        this.setAlignment(Pos.TOP_CENTER);
        this.setTranslateX(Field.getWIDTH() / 2 - 150);
        this.setTranslateY(Field.getHEIGHT() / 3);
    }

    public void addTextElement(Text text) {
        text.setFont(Font.font("Verdana", 50));
        if (texts.isEmpty()) {
            text.setFill(Color.WHITE);
        } else {
            text.setFill(Color.GREY);
        }
        texts.add(text);
        getChildren().add(text);
    }

    public void activate(int index) {
        texts.get(index).setFill(Color.WHITE);
    }

    public void deactivate(int index) {
        texts.get(index).setFill(Color.GREY);
    }
}
