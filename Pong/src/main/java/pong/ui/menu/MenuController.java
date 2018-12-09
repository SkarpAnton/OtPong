package pong.ui.menu;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pong.game.Field;

public abstract class MenuController {

    protected Stage stage;
    protected int currentElement = 0;
    protected MenuElements menu;

    protected abstract void addAndModifyChildren(Pane root);

    protected abstract void activate();

    public MenuController(MenuElements menu) {
        this.menu = menu;
    }

    public void run(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(createScene());
        stage.show();
    }

    protected Scene createScene() {
        Scene scene = new Scene(createRoot());
        scene.getStylesheets().add("css/pane_style.css");
        scene.setOnKeyPressed(event -> {
            action(event);
        });
        return scene;
    }

    protected void action(KeyEvent event) {
        if (event.getCode() == KeyCode.UP) {
            up();
        }

        if (event.getCode() == KeyCode.DOWN) {
            down();
        }

        if (event.getCode() == KeyCode.ENTER) {
            activate();
        }
    }

    protected Parent createRoot() {
        Pane root = new Pane();
        root.getStyleClass().add("black-background");
        root.setPrefSize(Field.getWIDTH(), Field.getHEIGHT());
        root.getChildren().addAll(menu);
        addAndModifyChildren(root);
        return root;
    }

    protected void up() {
        if (currentElement > 0) {
            menu.deactivate(currentElement);
            currentElement--;
            menu.activate(currentElement);
        }
    }

    protected void down() {
        if (currentElement < menu.getChildren().size() - 1) {
            menu.deactivate(currentElement);
            currentElement++;
            menu.activate(currentElement);
        }
    }

}
