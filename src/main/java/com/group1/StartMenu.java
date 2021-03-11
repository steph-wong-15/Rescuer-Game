package com.group1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class StartMenu {

    public void startButtonClick(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        Scene gameScreen = new Scene(root);
        //get stage from start menu to change scene to game
        Stage window = (Stage)(((Node)mouseEvent.getSource()).getScene().getWindow());
        window.setScene(gameScreen);
        window.centerOnScreen();
        window.show();
    }

    public void settingButtonClicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
        Scene pauseScreen = new Scene(root);
        //get stage from start menu to change scene to game
        Stage window = (Stage)(((Node)mouseEvent.getSource()).getScene().getWindow());
        window.setScene(pauseScreen);
        window.centerOnScreen();
        window.show();
    }
}
