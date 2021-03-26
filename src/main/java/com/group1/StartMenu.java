package com.group1;
import java.lang.*;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.*;
import java.io.IOException;
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

    int hostageCount = 0;

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
        Controller controller = new Controller(root);
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
//                updateScore();
                controller.tick();
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

//    private void createGoal() {
//        Image image = Main.greenImage;
//
//        // center horizontally, position at 70% vertically
//        double x = (Settings.SCENE_WIDTH - image.getWidth()) / 2.0;
//        double y = Settings.SCENE_HEIGHT * 0.7;
//
//        // create player
//        Goal end = new Goal(image, playfieldLayer, 1, 0, x, y, 0, 0, 0, 0);
//
//        // register player
//        goals.add(end);
//
//    }
//
//
//    private void updateScore() {
//        if (hostageCollision&&hostageCount<4){
//            collisionText.setFill(Color.GREEN);
//            collisionText.setStroke(Color.GREEN);
//            collisionText.setText("Hostaged rescued. \nNicely done!");
//            collisionText.setFill(Color.RED);
//            collisionText.setStroke(Color.BLACK);
//
//        }else if (hostageCollision==true && hostageCount==4) {
//            collisionText.setText("You saved four hostages!\n Go back to start!");
//            createGoal();
//
//
//        }else if (collision && over == false) {
//
//            collisionText.setText("Collision!\n Losing hp!");
//            for (Player player : players) {
//                player.getDamaged(player);
//                if (player.isAlive() == false) {
//                    over = true;
//                    collisionText.setText("Game over, 0 HP.");
//
//                    System.out.println("Player has died");
//                    loss();
//                }
//            }
//        }else if (goalState==true) {
//            collisionText.setText("You win!");
//
//
//        } else {
//            collisionText.setText("");
//        }
//    }
//
//    public void end() { //ending screen
//        ImagePattern pattern = new ImagePattern(Main.winnerImage);
//
//        Group root = new Group();
//
//        // create layers
//        playfieldLayer = new Pane();
//        scoreLayer = new Pane();
//        Button pauseButton =new Button("Quit");
//
//        root.getChildren().add( playfieldLayer);
//        root.getChildren().add( scoreLayer);
//        root.getChildren().add(pauseButton);
//        pauseButton.setOnAction(e->{
//
//                gameLoop.stop();
//                System.exit(0);
//
//        });
//
//        gameScene = new Scene( root, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
//        gameScene.setFill(pattern);
//        mainWindow.setScene( gameScene);
//        mainWindow.show();
//
//        System.out.println("Thanks for playing!");
//
//
//    }
//
//    public void loss() { //ending screen
//        ImagePattern pattern = new ImagePattern(Main.loserImage);
//
//        Group root = new Group();
//
//        // create layers
//        playfieldLayer = new Pane();
//        scoreLayer = new Pane();
//        Button pauseButton =new Button("Quit");
//
//        root.getChildren().add( playfieldLayer);
//        root.getChildren().add( scoreLayer);
//        root.getChildren().add(pauseButton);
//        pauseButton.setOnAction(e->{
//
//            gameLoop.stop();
//            System.exit(0);
//
//        });
//
//        gameScene = new Scene( root, Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
//        gameScene.setFill(pattern);
//        mainWindow.setScene( gameScene);
//        mainWindow.show();
//
//        System.out.println("Try again next time.");
//
//    }
//
}
