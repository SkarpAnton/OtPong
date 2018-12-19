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

    /**
     * Gives an opportunity to add or modify elements after creating menuelements
     * @param root where the elements are added
     */
    protected abstract void addAndModifyChildren(Pane root);

    /**
     * Abstract method that is meant to do a action that correlates with pressing enter
     */
    protected abstract void activate();

    public MenuController(MenuElements menu) {
        this.menu = menu;
    }

    /**
     * Creates a scene and sets the scene as the current scene
     * @param stage where the scene is set
     */
    public void run(Stage stage) {
        this.stage = stage;
        stage.setScene(createScene());
        stage.show();
    }

    private Scene createScene() {
        Scene scene = new Scene(createRoot());
        scene.getStylesheets().add("css/pane_style.css");
        scene.setOnKeyPressed(event -> {
            action(event);
        });
        return scene;
    }

    /**
     * Up and down movement in a menu and a action that is implemented in inheriting classes
     * @param event
     */
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

    private Parent createRoot() {
        Pane root = new Pane();
        root.getStyleClass().add("black-background");
        root.setPrefSize(Field.getWIDTH(), Field.getHEIGHT());
        root.getChildren().addAll(menu);
        addAndModifyChildren(root);
        return root;
    }

    private void up() {
        if (currentElement > 0) {
            menu.deactivate(currentElement);
            currentElement--;
            menu.activate(currentElement);
        }
    }

    private void down() {
        if (currentElement < menu.getChildren().size() - 1) {
            menu.deactivate(currentElement);
            currentElement++;
            menu.activate(currentElement);
        }
    }
    
    protected void runController(MenuController menuController) {
        menuController.run(stage);
    }

}
