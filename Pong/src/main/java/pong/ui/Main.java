/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.ui;

import pong.ui.GameController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Fake Pong");
        primaryStage.setScene(new GameController().getScene());
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
