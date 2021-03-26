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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.*;
import java.util.concurrent.TimeUnit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
/**
 * StartMenu
 * Executes the program functions
 */

public class StartMenu {

    Random rnd = new Random();
    Pane playfieldLayer = new Pane();
    Pane scoreLayer = new Pane();


    List<Player> players = new ArrayList<>();
    List<Enemies> enemies = new ArrayList<>();
    List<Hostages> hostages = new ArrayList<>();
    List<Goal> goals = new ArrayList<>();
    Text collisionText = new Text();
    boolean over = false; //check if game is over
    boolean collision = false; //check collision with enemy
    boolean hostageCollision = false; //hostage collision
    boolean goalState = false; //goalstate if true
    boolean firstHostage = false; //1st hostage checker
    boolean secondHostage = false; //2nd hostage checker
    boolean thirdHostage = false; //3rd hostage checker
    boolean fourthHostage = false; //4th hostage checker

    int hostageCount = 0;

    public int mapSize = 700; //temporarily set to 400 adjust if needed
    public int unitSize = 20;
    public int[][] map = new int[mapSize][mapSize];
    public CreateMap create = new CreateMap(mapSize, mapSize);


    public AnimationTimer gameLoop;
    Stage mainWindow;
    Scene gameScene;

    /**
     * Main game method where game loop runs
     * @param mouseEvent when player clicks play button
     */
    public void startButtonClick(MouseEvent mouseEvent) {
        ///////////////////////UI for main game screen//////////////////////
        //Outer layers
        BorderPane root = new BorderPane();
        StackPane group = new StackPane();
        gameScene = new Scene(root);

        // Inner layers
        playfieldLayer = new Pane();
        playfieldLayer.setPrefSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        BackgroundSize backgroundSize= new BackgroundSize(Settings.SCENE_WIDTH,Settings.SCENE_HEIGHT,true,true,true,false);
        BackgroundImage backgroundImage= new BackgroundImage(Main.myImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        playfieldLayer.setBackground(new Background(backgroundImage));

        scoreLayer = new Pane();
        scoreLayer.setPrefSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        Button pauseButton =new Button("Pause");

        //stack layers together
        group.getChildren().addAll( playfieldLayer,scoreLayer);
        root.setCenter(group);
        root.setBottom(pauseButton);
        root.setAlignment(pauseButton,Pos.CENTER);
        //get stage from start menu to change scenes with same stage
        mainWindow = (Stage) (((Node) mouseEvent.getSource()).getScene().getWindow());
        mainWindow.setScene(gameScene);
        mainWindow.centerOnScreen();
        mainWindow.show();
        //////////////////////UI for main game screen////////////////////////

        //////////////////////Game loop/////////////////////////////////////
        createScoreLayer();
        createPlayers();
        gameLoop = new AnimationTimer() {
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
        gameLoop.start();
        //////////////////////Game loop/////////////////////////////////////

        //Check for pauseButton
        pauseButton.setOnAction(e->{
            try {
                settingButtonClicked();
                gameLoop.stop();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    /**
     * Setting window is created and game pauses.
     * Includes quit and resume options
     */
    public void settingButtonClicked() throws IOException {
        ///////////////////////UI for setting popup window///////////////////
        BorderPane borderPane = new BorderPane();
        HBox hbox = new HBox();
        hbox.setPrefSize(Settings.SCENE_WIDTH / 2, Settings.SCENE_HEIGHT / 2);
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
        stage.setTitle("Settings");
        stage.show();
        ///////////////////////UI for setting popup window///////////////////

        //Check for quitButton and resumeButton
        resumeButton.setOnAction(e -> {
            stage.close();
            gameLoop.start();
        });
        quitButton.setOnAction(e -> {
            stage.close();
            mainWindow.close();
        });
    }


    private void createScoreLayer() { //create some text layer

        collisionText.setFont(Font.font(null, FontWeight.BOLD, 30));
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

    private void createPlayers() {

        // player input
        Input input = new Input(gameScene); //use temporary scene var

        // register input listeners
        input.addListeners();
        Image image = Main.playerImage;

        // center horizontally, position at 70% vertically
        double x = (Settings.SCENE_WIDTH - image.getWidth()) / 2.0;
        double y = Settings.SCENE_HEIGHT * 0.7;

        // create player
        Player player = new Player(image, playfieldLayer, Settings.PLAYER_HEALTH, 0, x, y, 0, 0, 0, 0, Settings.PLAYER_SPEED, input);

        // register player
        players.add(player);

    }
    private void createGoal() {


        Image image = Main.greenImage;

        // center horizontally, position at 70% vertically
        double x = (Settings.SCENE_WIDTH - image.getWidth()) / 2.0;
        double y = Settings.SCENE_HEIGHT * 0.7;

        // create player
        Goal end = new Goal(image, playfieldLayer, 1, 0, x, y, 0, 0, 0, 0);

        // register player
        goals.add(end);

    }
    private void spawnHostages() {

        // image
        Image image = Main.hostageImage;

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
        Hostages hostage4 = new Hostages(image, playfieldLayer, 1, 1, x+300, 0, speed, 0, 1, 1, "axe");
        // manage sprite
        hostages.add(hostage);
        hostages.add(hostage2);
        hostages.add(hostage3);
        hostages.add(hostage4);

    }
    private void spawnEnemies(boolean random) {

        if (random && rnd.nextInt(Settings.ENEMY_SPAWN_RANDOMNESS) != 0) {
            return;
        }

        // image
        Image image = Main.enemyImage;

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


    private void checkCollisions() {

        collision = false;
        hostageCollision = false;
        for (Player player : players) {
            for (Goal end : goals) {
                if (player.CharacterCollision(end)) { //if player hits Goal, true
                    collisionText.setText("You win!");
                    goalState = true;
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch(InterruptedException ex)
                    {
                        Thread.currentThread().interrupt();
                    }
                    end();

                }
            }
            for (Hostages hostage : hostages) {
                if (player.CharacterCollision(hostage)  &&firstHostage==false &&hostage.getName()=="speed") { //if player hits hostage, true
                    hostageCollision = true;
                    firstHostage=true;
                    hostageCount++;
                    updateScore();

                    break;
                }
                else if (player.CharacterCollision(hostage) && secondHostage==false && hostage.getName()=="sword") { //if player hits hostage, true
                    hostageCollision = true;
                    secondHostage=true;
                    hostageCount++;
                    updateScore();
                    break;

                }
                else if (player.CharacterCollision(hostage) &&thirdHostage==false&&hostage.getName()=="axe") { //if player hits hostage, true
                    hostageCollision = true;
                    thirdHostage=true;
                    hostageCount++;
                    updateScore();
                    break;
                }
                else if (player.CharacterCollision(hostage)&&fourthHostage==false&&hostage.getName()=="health") { //if player hits hostage, true
                    hostageCollision = true;
                    fourthHostage=true;
                    hostageCount++;
                    updateScore();
                    break;
                }

            for (Enemies enemy : enemies) {
                if (player.CharacterCollision(enemy)) { //if player hits enemy, true
                    collision = true;
                }
            }

            }
        }}



    private void updateScore() {
        if (hostageCollision&&hostageCount<4){
            collisionText.setFill(Color.GREEN);
            collisionText.setStroke(Color.GREEN);
            collisionText.setText("Hostaged rescued. \nNicely done!");
            collisionText.setFill(Color.RED);
            collisionText.setStroke(Color.BLACK);

        }else if (hostageCollision==true && hostageCount==4) {
            collisionText.setText("You saved four hostages!\n Go back to start!");
            createGoal();


        }else if (collision && over == false) {

            collisionText.setText("Collision!\n Losing hp!");
            for (Player player : players) {
                player.getDamaged(player);
                if (player.isAlive() == false) {
                    over = true;
                    collisionText.setText("Game over, 0 HP.");

                    System.out.println("Player has died");
                    loss();
                }
            }
        }else if (goalState==true) {
            collisionText.setText("You win!");


        } else {
            collisionText.setText("");
        }
    }

    public void end() { //ending screen
        ImagePattern pattern = new ImagePattern(Main.winnerImage);

        Group root = new Group();

        // create layers
        playfieldLayer = new Pane();
        scoreLayer = new Pane();
        Button pauseButton =new Button("Quit");

        root.getChildren().add( playfieldLayer);
        root.getChildren().add( scoreLayer);
        root.getChildren().add(pauseButton);
        pauseButton.setOnAction(e->{

                gameLoop.stop();
                System.exit(0);

        });

        gameScene = new Scene( root, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        gameScene.setFill(pattern);
        mainWindow.setScene( gameScene);
        mainWindow.show();

        System.out.println("Thanks for playing!");


    }

    public void loss() { //ending screen
        ImagePattern pattern = new ImagePattern(Main.loserImage);

        Group root = new Group();

        // create layers
        playfieldLayer = new Pane();
        scoreLayer = new Pane();
        Button pauseButton =new Button("Quit");

        root.getChildren().add( playfieldLayer);
        root.getChildren().add( scoreLayer);
        root.getChildren().add(pauseButton);
        pauseButton.setOnAction(e->{

            gameLoop.stop();
            System.exit(0);

        });

        gameScene = new Scene( root, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        gameScene.setFill(pattern);
        mainWindow.setScene( gameScene);
        mainWindow.show();

        System.out.println("Try again next time.");

    }

}
