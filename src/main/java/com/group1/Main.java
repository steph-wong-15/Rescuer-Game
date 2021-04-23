package com.group1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Main class where where game gets called and assets load
 */
public class Main extends Application {
    //image imports
    public static Image playerImage;
    public static Image enemyImage;
    public static Image hostageImage;
    public static Image myImage;
    public static Image greenImage;
    public static Image winnerImage;
    public static Image loserImage;
    public static Image healthImg;
    public static Image hostageImg;
    public static Image settingImg;
    public static Image closeImg;
    public static Image uiBg;
    public static Image playImg;
    public static Image bg;
    public static Image bonus;
    public static Image wallImg;
    public static Image wallImgA;
    public static Image wallImgB;

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
        stage.setTitle("Game");
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
        healthImg = new Image(getClass().getResource("/photos/Heart1.png").toExternalForm(),60,60,false,true);
        hostageImg = new Image(getClass().getResource("/photos/hostage.png").toExternalForm(),65,70,false,true);
        settingImg= new Image(getClass().getResource("/photos/settings.png").toExternalForm(),60,60,false,true);
        closeImg= new Image(getClass().getResource("/photos/close.png").toExternalForm(),50,50,false,true);
        uiBg=new Image(getClass().getResource("/photos/uiBG.png").toExternalForm(),1000,200,false,true);
        playImg= new Image(getClass().getResource("/photos/play.png").toExternalForm(),50,50,false,true);
        bg = new Image(getClass().getResource("/photos/backgroundStart.png").toExternalForm());
        bonus = new Image(getClass().getResource("/photos/purple.png").toExternalForm());
        wallImg = new Image(getClass().getResource("/photos/block.jpg").toExternalForm(),150,50,false,true);
        wallImgA = new Image(getClass().getResource("/photos/wall.png").toExternalForm(),15,500,false,true);
        wallImgB = new Image(getClass().getResource("/photos/wall.png").toExternalForm(),750,15,false,true);
    }

    /**
     * main function that is called when program runs
     * @param args args
     */
    public static void main(String[]args){
        Application.launch();
    }

}
