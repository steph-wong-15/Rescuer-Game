package com.group1;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StartMenu {
    int mv=0;
    public static final int gameWidth =600;
    public static final int gameHeight =400;
    public GameTimer timer;
    Stage mainWindow;
    public void startButtonClick(MouseEvent mouseEvent){
        ///////////////////////UI for main game screen//////////////////////
        BorderPane borderPane = new BorderPane();
        Canvas canvas = new Canvas();
        Button pauseButton = new Button("PAUSE");
        canvas.setWidth(gameWidth);
        canvas.setHeight(gameHeight);
        pauseButton.setPrefSize(110,30);
        borderPane.setCenter(canvas);
        borderPane.setBottom(pauseButton);
        borderPane.setAlignment(pauseButton,Pos.CENTER);
        Scene gameScene = new Scene(borderPane);
        //////////////////////UI for main game screen////////////////////////

        //get stage from start menu to change scenes with same stage
        mainWindow = (Stage)(((Node)mouseEvent.getSource()).getScene().getWindow());
        mainWindow.setScene(gameScene);
        mainWindow.setTitle("Game");
        mainWindow.centerOnScreen();
        mainWindow.show();
        //Game loop
        timer = new GameTimer() {
            @Override
            public void tick(long now) {
                GraphicsContext gc = canvas.getGraphicsContext2D();
                gc.setFill(Color.WHITE);
                gc.fillRect(0,0,1000,1000);
                gc.setFill(Color.BLUE);
                gc.fillRect(100+mv,100,50,50);
                mv++;
            }
        };
        timer.start();
        //Action Listener for pausing game
        pauseButton.setOnAction(e-> {
            try {
                settingButtonClicked();
                timer.stop();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.A) {
                    System.out.println("LEFT");
                }
                else if(keyEvent.getCode()== KeyCode.D) {
                    System.out.println("RIGHT");
                }
                else if(keyEvent.getCode()== KeyCode.W) {
                    System.out.println("UP");
                }
                else if(keyEvent.getCode()== KeyCode.S) {
                    System.out.println("DOWN");
                }
            }
        });
    }

    public void settingButtonClicked() throws IOException {
        ///////////////////////UI for setting popup window///////////////////
        BorderPane borderPane = new BorderPane();
        HBox hbox = new HBox();
        hbox.setPrefSize(gameWidth/2,gameHeight/2);
        Button quitButton = new Button("QUIT");
        hbox.setSpacing(10);
        Button resumeButton = new Button("RESUME");
        hbox.getChildren().addAll(quitButton,resumeButton);
        hbox.setAlignment(Pos.CENTER);
        borderPane.setCenter(hbox);
        Scene settingScene = new Scene(borderPane);
        Stage stage = new Stage();
        stage.setTitle("Paused");
        stage.setScene(settingScene);
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        ///////////////////////UI for setting popup window///////////////////

        resumeButton.setOnAction(e->{
            stage.close();
            timer.start();
        });

        quitButton.setOnAction(e->{
            stage.close();
            mainWindow.close();
        });
    }

}
