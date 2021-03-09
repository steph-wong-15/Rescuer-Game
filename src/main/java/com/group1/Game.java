package com.group1;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Game {
    public void mouseClick(MouseEvent mouseEvent) {

        Group root = new Group();
        Scene game = new Scene(root);
        Canvas canvas = new Canvas(1000,800);
        root.getChildren().add(canvas);
        //get stage from start menu to change scene to game
        Stage window = (Stage)(((Node)mouseEvent.getSource()).getScene().getWindow());
        window.setScene(game);
        //center game screen(opens off centered without this)
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        window.setX((primScreenBounds.getWidth() - window.getWidth()) / 2);
        window.setY((primScreenBounds.getHeight() - window.getHeight()) / 2);
        window.show();
    }
}
