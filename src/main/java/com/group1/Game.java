package com.group1;


import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Game{

    public Canvas theCanvas;
    public GameTimer timer;

    public int mapSize=10;
    public int unitSize=20;
    public int[][] map = new int[mapSize][mapSize];
    public CreateMap create = new CreateMap(mapSize,mapSize);

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
                Pane pane = InitPane();
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

    public void start(Stage stage){

        create.InitMap(); //create a map

        Pane pane  = InitPane();
        Scene scene = new Scene(pane,mapSize,mapSize);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("RESCUE GAME");
        stage.show();
    }

    public Pane InitPane() {

        Pane pane = new Pane();

        for (int i = 0; i < mapSize; i += unitSize) {

            for (int j = 0; j < mapSize; j += unitSize) {

                Rectangle tile = new Rectangle(i, j, unitSize, unitSize);

                if (map[i][j] == 0) {

                    tile.setFill(Color.BLUEVIOLET);

                } else if (map[i][j] == 1) {

                    tile.setFill(Color.GREENYELLOW);
                }
                if (i == mapSize - unitSize && j == mapSize - unitSize * 2) {

                    tile.setFill(Color.DARKORANGE);
                }
                pane.getChildren().add(tile);
            }
        }
        return pane;
    }

}
