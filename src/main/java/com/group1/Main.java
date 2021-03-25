package com.group1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
    //image imports
    public static Image playerImage;
    public static Image enemyImage;
    public static Image hostageImage;
    public static Image myImage;
    public static Image greenImage;
    public static Image winnerImage;
    public static Image loserImage;

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

    /**
     * load assets
     */
    @Override
    public void init()  {
        playerImage = new Image(getClass().getResource("/photos/player.png").toExternalForm());
        enemyImage = new Image(getClass().getResource("/photos/enemy.png").toExternalForm());
        hostageImage = new Image(getClass().getResource("/photos/hostages.png").toExternalForm());
        greenImage = new Image(getClass().getResource("/photos/green.png").toExternalForm());
        myImage = new Image(getClass().getResource("/photos/background.png").toExternalForm());
        winnerImage = new Image(getClass().getResource("/photos/winner.png").toExternalForm());
        loserImage = new Image(getClass().getResource("/photos/death.png").toExternalForm());
    }

    public static void main(String[]args){
        Application.launch();
    }


}
