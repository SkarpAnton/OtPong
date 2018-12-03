package pong.ui.menu.difficulty;

import javafx.scene.text.Text;
import pong.ui.menu.MenuBox;

public class DifficultyElements {

    private MenuBox settings;

    public DifficultyElements() {
        initializeSettings();
    }

    private void initializeSettings() {
        settings = new MenuBox();
        settings.addTextElement(new Text("Slow"));
        settings.addTextElement(new Text("Normal"));
        settings.addTextElement(new Text("Fast"));
        settings.addTextElement(new Text("Super fast"));
    }

    public MenuBox getSettings() {
        return settings;
    }
}
