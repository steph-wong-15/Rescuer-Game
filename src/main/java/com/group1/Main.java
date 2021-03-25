package com.group1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
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
