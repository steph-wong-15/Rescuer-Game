package com.group1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class start extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    Parent startMenu = FXMLLoader.load(getClass().getClassLoader().getResource("StartMenu.fxml"));
    Scene scene1 = new Scene(startMenu);
    stage.setScene(scene1);
    stage.show();
    }

}
