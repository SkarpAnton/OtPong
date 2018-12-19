
package pong.ui.menu.pause;

import javafx.scene.text.Text;
import pong.ui.menu.MenuElements;

public class PauseElements extends MenuElements {

    public PauseElements() {
        this.addTextElement(new Text("Continue"));
        this.addTextElement(new Text("Back to menu"));
    }

}
