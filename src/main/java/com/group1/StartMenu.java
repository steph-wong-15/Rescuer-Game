package com.group1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class StartMenu {
    int mv=0;
    final int gameWidth =600;
    final int gameHeight =400;
    public GameTimer timer;
    Stage mainWindow;
    public void startButtonClick(MouseEvent mouseEvent){
        //UI for main game screen
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
        //get stage from start menu to change scene to game
        mainWindow = (Stage)(((Node)mouseEvent.getSource()).getScene().getWindow());
        mainWindow.setScene(gameScene);
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
        pauseButton.setOnAction(e-> {
            try {
                settingButtonClicked();
                timer.stop();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        timer.start();
    }

    public void settingButtonClicked() throws IOException {
        //UI for setting popup window
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
        stage.setScene(settingScene);
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

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
