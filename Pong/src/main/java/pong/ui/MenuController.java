package pong.ui;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import pong.game.Field;

public abstract class MenuController {

    protected Stage stage;
    protected int currentItem = 0;
    protected MenuBox menu;
    
    protected abstract void addAdditionalChildren(Pane root);

    protected abstract void activate();
    
    public MenuController(MenuBox menu) {
        this.menu = menu;
    }
    
    public void run(Stage stage) throws Exception {
        this.stage = stage;
        stage.setScene(createScene());        
        stage.show();
    }
    
    protected Scene createScene() {
        Scene scene = new Scene(createRoot());
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                up();
            }
            
            if (event.getCode() == KeyCode.DOWN) {
                down();
            }
            
            if (event.getCode() == KeyCode.ENTER) {
                activate();
            }
        });
        return scene;
    }
    
    protected Parent createRoot() {
        Pane root = new Pane();
        root.setPrefSize(Field.getWIDTH(), Field.getHEIGHT());
        Rectangle background = new Rectangle(Field.getWIDTH(), Field.getHEIGHT());        
        root.getChildren().addAll(background, menu);
        addAdditionalChildren(root);
        return root;
    }
    
    protected void up() {
        if (currentItem > 0) {
            menu.deactivate(currentItem);
            currentItem--;
            menu.activate(currentItem);
        }
    }
    
    protected void down() {
        if (currentItem < menu.getChildren().size() - 1) {
            menu.deactivate(currentItem);
            currentItem++;
            menu.activate(currentItem);
        }
    }
    
}
