package com.group1;
import java.lang.*;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.concurrent.TimeUnit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StartMenu {
    @FXML

    Random rnd = new Random();

    Pane playfieldLayer = new Pane();
    Pane scoreLayer = new Pane();

    Image playerImage;
    Image enemyImage;
    Image hostageImage;
    Image myImage;
    Image greenImage;
    Scene scene;
    List<Player> players = new ArrayList<>();
    List<Enemies> enemies = new ArrayList<>();
    List<Hostages> hostages = new ArrayList<>();
    List<Goal> goals = new ArrayList<>();
    Text collisionText = new Text();
    boolean collision = false;
    boolean hostageCollision = false;
    boolean goalCollision = false;
    int hostageCount = 0;

    public int mapSize = 600; //temporarily set to 400 adjust if needed
    public int unitSize = 20;
    public int[][] map = new int[mapSize][mapSize];
    public CreateMap create = new CreateMap(mapSize, mapSize);


    public Canvas theCanvas;
    int mv = 0;
    final int gameWidth = 600;
    final int gameHeight = 600;
    public GameTimer timer;
    public AnimationTimer gameLoop;
    Stage mainWindow;
    Stage primaryStage;
<<<<<<< HEAD

=======
>>>>>>> f62bc7f3d3a8a99edd23e793287cd05c212bd845

    /**
     * Main game method where game loop runs
     * @param mouseEvent when player clicks play button
     */
    public void startButtonClick(MouseEvent mouseEvent) {
        ///////////////////////UI for main game screen//////////////////////
        loadGame();
        BorderPane borderPane = new BorderPane();
        Canvas canvas = new Canvas();
        Button pauseButton = new Button("PAUSE");
        canvas.setWidth(gameWidth);
        canvas.setHeight(gameHeight);
        pauseButton.setPrefSize(110, 30);
        borderPane.setCenter(canvas);
        borderPane.setBottom(pauseButton);
        borderPane.setAlignment(pauseButton, Pos.CENTER);
        Scene gameScene = new Scene(borderPane);
        //////////////////////UI for main game screen////////////////////////

        //get stage from start menu to change scenes with same stage
        mainWindow = (Stage) (((Node) mouseEvent.getSource()).getScene().getWindow());
        mainWindow.setScene(gameScene);
        mainWindow.centerOnScreen();
        mainWindow.show();
        //Game loop
        loadGame();
        //Action Listener for pausing game

        System.out.println("Loading");
        gameLoop = new AnimationTimer() {
<<<<<<< HEAD

=======
>>>>>>> f62bc7f3d3a8a99edd23e793287cd05c212bd845

            @Override
            public void handle(long now) {

                // player input
                players.forEach(sprite -> sprite.processInput());

                // add random enemies
                spawnEnemies(true);
                // add hostages
                spawnHostages();
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


                // update score, health, etc
                updateScore();
            }

        };
        System.out.println("Loaded.");
        gameLoop.start();
        test();

    }

    /**
     * Setting window is created and game pauses.
     * Includes quit and resume options
     */
    public void settingButtonClicked() {
        ///////////////////////UI for setting popup window///////////////////
        BorderPane borderPane = new BorderPane();
        HBox hbox = new HBox();
        hbox.setPrefSize(gameWidth / 2, gameHeight / 2);
        Button quitButton = new Button("QUIT");
        hbox.setSpacing(10);
        Button resumeButton = new Button("RESUME");
        hbox.getChildren().addAll(quitButton, resumeButton);
        hbox.setAlignment(Pos.CENTER);
        borderPane.setCenter(hbox);
        Scene settingScene = new Scene(borderPane);
        Stage stage = new Stage();
        stage.setScene(settingScene);
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
        ///////////////////////UI for setting popup window///////////////////

        resumeButton.setOnAction(e -> {
            stage.close();
            gameLoop.start();
<<<<<<< HEAD

=======
>>>>>>> f62bc7f3d3a8a99edd23e793287cd05c212bd845
        });

        quitButton.setOnAction(e -> {
            stage.close();
            primaryStage.close();
<<<<<<< HEAD

=======
>>>>>>> f62bc7f3d3a8a99edd23e793287cd05c212bd845
        });
    }

    /**
     * Load window/stage assets
     */
    public void test() {
<<<<<<< HEAD
        ImagePattern pattern = new ImagePattern(myImage);

=======
>>>>>>> f62bc7f3d3a8a99edd23e793287cd05c212bd845
        primaryStage = new Stage();
        primaryStage.centerOnScreen();
        Group root = new Group();

        // create layers
        playfieldLayer = new Pane();
        scoreLayer = new Pane();
        Button pauseButton =new Button("Pause");

        root.getChildren().add( playfieldLayer);
        root.getChildren().add( scoreLayer);
        root.getChildren().add(pauseButton);
<<<<<<< HEAD
        pauseButton.setOnAction(e->{
            try {
                settingButtonClicked();
                gameLoop.stop();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
=======

        pauseButton.setOnAction(e->{
            settingButtonClicked();
            gameLoop.stop();
>>>>>>> f62bc7f3d3a8a99edd23e793287cd05c212bd845
        });

        scene = new Scene( root, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        scene.setFill(pattern);
        primaryStage.setScene( scene);
        primaryStage.show();

        loadGame();
        createScoreLayer();
        createPlayers();


    }

<<<<<<< HEAD
=======
//    public Pane InitPane() {
//
//        Pane pane = new Pane();
//
//        for (int i = 0; i < mapSize; i += unitSize) {
//
//            for (int j = 0; j < mapSize; j += unitSize) {
//
//                Rectangle tile = new Rectangle(i, j, unitSize, unitSize);
//
//                if (map[i][j] == 0) {
//
//                    tile.setFill(Color.BLUEVIOLET);
//
//                } else if (map[i][j] == 1) {
//
//                    tile.setFill(Color.GREENYELLOW);
//                }
//                if (i == mapSize - unitSize && j == mapSize - unitSize * 2) {
//
//                    tile.setFill(Color.DARKORANGE);
//                }
//                pane.getChildren().add(tile);
//            }
//        }
//        return pane;
//    }

    /**
     * load images
     */
>>>>>>> f62bc7f3d3a8a99edd23e793287cd05c212bd845
    private void loadGame() {
        playerImage = new Image(getClass().getResource("/photos/player.png").toExternalForm());
        enemyImage = new Image(getClass().getResource("/photos/enemy.png").toExternalForm());
        hostageImage = new Image(getClass().getResource("/photos/hostages.png").toExternalForm());
        greenImage = new Image(getClass().getResource("/photos/green.png").toExternalForm());
        myImage = new Image(getClass().getResource("/photos/background.png").toExternalForm());
    }

    /**
     * Collision effect when player touches enemies
     */
    private void createScoreLayer() {


        collisionText.setFont(Font.font(null, FontWeight.BOLD, 32));
        collisionText.setStroke(Color.BLACK);
        collisionText.setFill(Color.RED);

        scoreLayer.getChildren().add(collisionText);

        collisionText.setText("Collision");
        double x = (Settings.SCENE_WIDTH - collisionText.getBoundsInLocal().getWidth()) / 2;
        double y = (Settings.SCENE_HEIGHT - collisionText.getBoundsInLocal().getHeight()) / 2;
        collisionText.relocate(x, y);
        collisionText.setText("");

        collisionText.setBoundsType(TextBoundsType.VISUAL);


    }

    /**
     * Creating player
     */
    private void createPlayers() {

        // player input
        Input input = new Input(scene); //use temporary scene var

        // register input listeners
        input.addListeners();
        loadGame();
        Image image = playerImage;

        // center horizontally, position at 70% vertically
        double x = (Settings.SCENE_WIDTH - image.getWidth()) / 2.0;
        double y = Settings.SCENE_HEIGHT * 0.7;

        // create player
        Player player = new Player(image, playfieldLayer, Settings.PLAYER_HEALTH, 0, x, y, 0, 0, 0, 0, Settings.PLAYER_SPEED, input);

        // register player
        players.add(player);

    }
    private void createGoal() {


        Image image = greenImage;

        // center horizontally, position at 70% vertically
        double x = (Settings.SCENE_WIDTH - image.getWidth()) / 2.0;
        double y = Settings.SCENE_HEIGHT * 0.7;

        // create player
        Goal end = new Goal(image, playfieldLayer, 1, 0, x, y, 0, 0, 0, 0);

        // register player
        goals.add(end);

    }
    private void spawnHostages() {

<<<<<<< HEAD
        // image
        Image image = hostageImage;

        // random speed
        double speed = 0;

        // make enemy is always fully inside the screen, no part of it is outside
        // y position: right on top of the view, so that it becomes visible with the next game iteration
        double x = 200;
        double y = 50;

        // create a sprite
        Hostages hostage = new Hostages(image, playfieldLayer, 1, 1, x, 0, speed, 0, 1, 1, "speed");
        Hostages hostage2 = new Hostages(image, playfieldLayer, 1, 1, x-150, 0, speed, 0, 1, 1, "health");
        Hostages hostage3 = new Hostages(image, playfieldLayer, 1, 1, x+200, 0, speed, 0, 1, 1, "sword");
        Hostages hostage4 = new Hostages(image, playfieldLayer, 1, 1, x+400, 0, speed, 0, 1, 1, "axe");
        // manage sprite
        hostages.add(hostage);
        hostages.add(hostage2);
        hostages.add(hostage3);
        hostages.add(hostage4);

    }
=======
    /**
     * Enemy spawner
     * @param random helps with randomzing enemy creation
     */
>>>>>>> f62bc7f3d3a8a99edd23e793287cd05c212bd845
    private void spawnEnemies(boolean random) {

        if (random && rnd.nextInt(Settings.ENEMY_SPAWN_RANDOMNESS) != 0) {
            return;
        }

        // image
        Image image = enemyImage;

        // random speed
        double speed = rnd.nextDouble() * 1.0 + 2.0;

        // make enemy is always fully inside the screen, no part of it is outside
        // y position: right on top of the view, so that it becomes visible with the next game iteration
        double x = rnd.nextDouble() * (Settings.SCENE_WIDTH - image.getWidth());
        double y = -image.getHeight();

        // create a sprite
        Enemies enemy = new Enemies(image, playfieldLayer, 1, 1, x, 0, speed, 0, 1, 1);

        // manage sprite
        enemies.add(enemy);

    }


    /**
     * Collison detection
     */
    private void checkCollisions() {

        collision = false;
        hostageCollision = false;
        goalCollision = false;
        for (Player player : players) {
            for (Enemies enemy : enemies) {
                if (player.CharacterCollision(enemy)) { //if player hits enemy, true
                    collision = true;
                }
            }
            for (Hostages hostage: hostages){
                if (player.CharacterCollision(hostage)) { //if player hits hostage, true
                    hostageCollision = true;



                }
            }
            for (Goal end: goals){
                if (player.CharacterCollision(end)) { //if player hits hostage, true
                    goalCollision = true;



                }
            }
        }
    }

    /**
     * Track score
     */
    private void updateScore() {
        if (collision) {
            collisionText.setText("Collision!\n -1 hp!");
            for (Player player : players) {
                player.getDamaged(player);
                if (player.isAlive() == false) {
                    System.out.println("dead");
                    collisionText.setText("Game over, 0 HP.");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    System.exit(0);
                }
            }

        }else if (hostageCollision&&hostageCount<4){
            collisionText.setText("You saved one hostage!\n Well done!");
            hostageCount++;
        }else if (hostageCollision&&hostageCount>4) {
            collisionText.setText("You saved four hostages!\n Go back to start!");
            createGoal();

        }else if (goalCollision&&hostageCount>4) {
            collisionText.setText("You win!");
            System.exit(0);
        } else {
            collisionText.setText("");
        }
    }

}