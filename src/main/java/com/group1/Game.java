package com.group1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Game {
    int mv=0;
    public void mouseClick(MouseEvent mouseEvent) {
        Group root = new Group();
        Scene game = new Scene(root);
        Canvas canvas = new Canvas(1000,800);
        Button b1 = new Button("STOP");
        root.getChildren().addAll(canvas,b1);
        //get stage from start menu to change scene to game
        Stage window = (Stage)(((Node)mouseEvent.getSource()).getScene().getWindow());
        window.setScene(game);
        window.centerOnScreen();
        window.show();

        GameTimer timer = new GameTimer() {
            @Override
            public void tick(long now) {
                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.setFill(Color.WHITE);
                gc.fillRect(0,0,1000,1000);
                gc.setFill(Color.BLUE);
                gc.fillRect(500+mv,400,50,50);
                mv++;
            }
        };
        timer.start();

        b1.setOnAction(e->{
            if(timer.running){
                timer.stop();
                timer.running =false;
            }
            else{
                timer.start();
            }
        });
    }
}
