package com.group1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    /**
     * loads starting screen UI
     * @param stage starting stage
     * @throws Exception exception handling if FXMLLoader fails
     */

    @Override
    public void start(Stage stage) throws Exception {
        Parent startMenu = FXMLLoader.load(getClass().getResource("StartMenu.fxml"));
        Scene scene1 = new Scene(startMenu);
        stage.setScene(scene1);
        stage.setTitle("Start");
        stage.show();

    }

    public static void main(String[]args){
        Application.launch();
    }


}
