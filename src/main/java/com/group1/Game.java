package com.group1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;


public class Game {
    @FXML

    Random rnd = new Random();

    Pane playfieldLayer;
    Pane scoreLayer;

    Image playerImage;
    Image enemyImage;
    Scene scene;
    List<Player> players = new ArrayList<>();
    List<Enemies> enemies = new ArrayList<>();

    Text collisionText = new Text();
    boolean collision = false;

    public int mapSize=400; //temporarily set to 400 adjust if needed
    public int unitSize=20;
    public int[][] map = new int[mapSize][mapSize];
    public CreateMap create = new CreateMap(mapSize,mapSize);


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
        loadGame();

        createScoreLayer();
        createPlayers();
        AnimationTimer gameLoop = new AnimationTimer() {

            @Override
            public void handle(long now) {

                // player input
                players.forEach(sprite -> sprite.processInput());

                // add random enemies
                spawnEnemies( true);

                // movement
                players.forEach(sprite -> sprite.move());
                enemies.forEach(sprite -> sprite.move());

                // check collisions
                checkCollisions();

                // update sprites in scene
                players.forEach(sprite -> sprite.updateUI());
                enemies.forEach(sprite -> sprite.updateUI());

                // check if sprite can be removed
                enemies.forEach(sprite -> sprite.checkRemovability());

                // remove removables from list, layer, etc
//                removeSprites( enemies);

                // update score, health, etc
                updateScore();
            }

        };
        gameLoop.start();

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

    private void loadGame() {
        playerImage = new Image( getClass().getResource("player.png").toExternalForm());
        enemyImage = new Image( getClass().getResource("enemy.png").toExternalForm());
    }
    private void createScoreLayer() {


        collisionText.setFont( Font.font( null, FontWeight.BOLD, 64));
        collisionText.setStroke(Color.BLACK);
        collisionText.setFill(Color.RED);

        scoreLayer.getChildren().add( collisionText);

        collisionText.setText("Collision");
        double x = (Settings.SCENE_WIDTH - collisionText.getBoundsInLocal().getWidth()) / 2;
        double y = (Settings.SCENE_HEIGHT - collisionText.getBoundsInLocal().getHeight()) / 2;
        collisionText.relocate(x, y);
        collisionText.setText("");

        collisionText.setBoundsType(TextBoundsType.VISUAL);


    }

    private void createPlayers() {

        // player input
        Input input = new Input(scene); //use temporary scene var

        // register input listeners
        input.addListeners();

        Image image = playerImage;

        // center horizontally, position at 70% vertically
        double x = (Settings.SCENE_WIDTH - image.getWidth()) / 2.0;
        double y = Settings.SCENE_HEIGHT * 0.7;

        // create player
        Player player = new Player(image,playfieldLayer, Settings.PLAYER_HEALTH, 0, x, y, 0, 0, 0, 0,  Settings.PLAYER_SPEED, input);

        // register player
        players.add( player);

    }

    private void spawnEnemies( boolean random) {

        if( random && rnd.nextInt(Settings.ENEMY_SPAWN_RANDOMNESS) != 0) {
            return;
        }

        // image
        Image image = enemyImage;

        // random speed
        double speed = rnd.nextDouble() * 1.0 + 2.0;

        // x position range: enemy is always fully inside the screen, no part of it is outside
        // y position: right on top of the view, so that it becomes visible with the next game iteration
        double x = rnd.nextDouble() * (Settings.SCENE_WIDTH - image.getWidth());
        double y = -image.getHeight();

        // create a sprite
        Enemies enemy = new Enemies(image, playfieldLayer, 1, 1, x, 0, speed, 0, 1,1);

        // manage sprite
        enemies.add(enemy);

    }

//    private void removeSprites(  List<? extends Person> spriteList) {
//        Iterator<? extends Person> iter = Person.iterator();
//        while( iter.hasNext()) {
//            Person sprite = iter.next();
//
//            if( sprite.isRemovable()) {
//
//                // remove from layer
//                sprite.removeFromLayer();
//
//                // remove from list
//                iter.remove();
//            }
//        }
//    }

    private void checkCollisions() {

        collision = false;

        for( Player player: players) {
            for( Enemies enemy: enemies) {
                if( player.CharacterCollision(enemy)) { //if player hits enemy, true
                    collision = true;
                }
            }
        }
    }
    private void updateScore() {
        if( collision) {
            collisionText.setText("Collision");
        } else {
            collisionText.setText("");
        }
    }

}
