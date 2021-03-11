package com.group1;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


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

    public void pauseClicked(MouseEvent mouseEvent) {
        if(timer!=null){
            if(timer.running){
                timer.stop();
                timer.running =false;
            }
            else{
                timer.start();
            }
        }
    }
}
