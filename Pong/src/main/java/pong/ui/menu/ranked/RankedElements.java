package pong.ui.menu.ranked;


import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import pong.ui.menu.MenuElements;

public class RankedElements extends MenuElements {

    private VBox textFields;
    private TextField p1TextField;
    private TextField p2TextField;
    private Text errorMessage;

    public RankedElements() {
        intializeMenu();
        initializeErrorMessage();
        initializeTextFields();
    }

    private void intializeMenu() {
        this.addTextElement(new Text("P1:              "));
        this.addTextElement(new Text("P2:              "));
        Text play = new Text("Play");
        play.setTextAlignment(TextAlignment.RIGHT);
        this.addTextElement(play);
    }
    
    private void initializeErrorMessage() {
        errorMessage = new Text("Both player one and player two should have defined names");
        errorMessage.setFont(Font.font("Verdana", 20));
        errorMessage.setTextAlignment(TextAlignment.CENTER);
        errorMessage.setTranslateX(300);
        errorMessage.setTranslateY(100);
        errorMessage.setFill(Color.WHITE);
        errorMessage.setVisible(false);
    }

    private void initializeTextFields() {
        p1TextField = initializeTextField();
        p2TextField = initializeTextField();
        textFields = new VBox(p1TextField, p2TextField);
        
    }

    private TextField initializeTextField() {
        TextField textField = new TextField();
        textField.setFont(Font.font("Verdana", 30));
        textField.setTranslateX(550);
        textField.setTranslateY(280);
        textField.getStyleClass().add("black-background");
        textField.getStyleClass().add("white-text");
        return textField;
    }

    public VBox getTextFields() {
        return textFields;
    }

    public TextField getP2TextField() {
        return p2TextField;
    }

    public TextField getP1TextField() {
        return p1TextField;
    }

    public Text getErrorMessage() {
        return errorMessage;
    }

    @Override
    public void activate(int index) {
        this.texts.get(index).setFill(Color.WHITE);
        switch (index) {
            case 0:
                activateTextField(p1TextField);
                break;
            case 1:
                activateTextField(p2TextField);
                break;
            default:
                this.requestFocus();
                break;               
        }
    }

    private void activateTextField(TextField textField) {
        textField.requestFocus();
        textField.getStyleClass().remove("gray-text");
        textField.getStyleClass().add("white-text");
    }

    @Override
    public void deactivate(int index) {
        this.texts.get(index).setFill(Color.GREY);
        if (index == 0) {
            deactivateTextField(p1TextField);
        } else if (index == 1) {
            deactivateTextField(p2TextField);
        }
    }

    private void deactivateTextField(TextField textField) {
        textField.requestFocus();
        textField.getStyleClass().remove("white-text");
        textField.getStyleClass().add("gray-text");
    }
}
