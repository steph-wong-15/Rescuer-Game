package com.group1;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class Game{
    public Canvas theCanvas;
    public GameTimer timer;
    int mv=0;
    public void playClicked(MouseEvent mouseEvent) {
        timer = new GameTimer() {
            @Override
            public void tick(long now) {
                GraphicsContext gc = theCanvas.getGraphicsContext2D();
                gc.setFill(Color.WHITE);
                gc.fillRect(0,0,1000,1000);
                gc.setFill(Color.BLUE);
                gc.fillRect(500+mv,400,50,50);
                mv++;
            }
        };
        timer.start();
    }

    public void pauseClicked(MouseEvent mouseEvent) throws IOException {
        if(timer!=null) {
//            Parent root = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
//            Scene pauseScreen = new Scene(root);
//            Stage popWindow = new Stage();
//            popWindow.setScene(pauseScreen);
//            popWindow.centerOnScreen();
//            popWindow.initModality(Modality.APPLICATION_MODAL);
//            popWindow.show();
            timer.stop();
        }
    }
}
