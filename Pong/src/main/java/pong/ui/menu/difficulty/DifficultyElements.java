package pong.ui.menu.difficulty;

import javafx.scene.text.Text;
import pong.ui.menu.MenuElements;

public class DifficultyElements extends MenuElements {

    public DifficultyElements() {
        this.addTextElement(new Text("Slow"));
        this.addTextElement(new Text("Normal"));
        this.addTextElement(new Text("Fast"));
        this.addTextElement(new Text("Super fast"));
    }

}
