package com.group1;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class Score {
    boolean over = false; //check if game is over
    boolean collision = false; //check collision with enemy
    boolean hostageCollision = false; //hostage collision
    boolean goalState = false; //goalstate if true
    int hostageCount = 0;
    Text collisionText;
    Pane layer;
    Player thePlayer;
    Score(Pane pane, Player player) {
        layer = pane;
        thePlayer=player;
        createScoreLayer();
    }

    /**
     * Layer that displays text when events occur
     */
    private void createScoreLayer() {
        collisionText=new Text();
        collisionText.setFont(Font.font(null, FontWeight.BOLD, 30));
        collisionText.setStroke(Color.BLACK);
        collisionText.setFill(Color.RED);
        double x = (Settings.SCENE_WIDTH - collisionText.getBoundsInLocal().getWidth()) / 2;
        double y = (Settings.SCENE_HEIGHT - collisionText.getBoundsInLocal().getHeight()) / 2;
        collisionText.relocate(x, y);
        collisionText.setBoundsType(TextBoundsType.VISUAL);
        layer.getChildren().add(collisionText);

    }

    /**
     * Makes bonus reward
     */
    public Goal createGoal() {
        Image image = Main.greenImage;
        // center horizontally, position at 70% vertically
        double x = (Settings.SCENE_WIDTH - image.getWidth()) / 2.0;
        double y = Settings.SCENE_HEIGHT * 0.7;
        // create goal
        return new Goal(image, layer, 1, 0, x, y, 0, 0, 0, 0);
    }

    /**
     * Increase score
     */
    public void increaseScore() {
        hostageCount++;
    }

    /**
     * Update score for score layer
     */
    public void updateScore() {
        if (hostageCollision&&hostageCount<4){
            collisionText.setFill(Color.GREEN);
            collisionText.setStroke(Color.GREEN);
            collisionText.setText("Hostaged rescued. \nNicely done!");
            collisionText.setFill(Color.RED);
            collisionText.setStroke(Color.BLACK);
        }else if (hostageCount==4) {
            collisionText.setText("You saved four hostages!\n Go back to start!");
            createGoal();
        }
//        }else if (collision && over == false) {
//            collisionText.setText("Collision!\n Losing hp!");
//            thePlayer.getDamaged();
//            if (thePlayer.isAlive() == false) {
//                over = true;
//                collisionText.setText("Game over, 0 HP.");
//                System.out.println("Player has died");
//                loss();
//            }
//        }else if (goalState==true) {
//            collisionText.setText("You win!");
//       } else {
//            collisionText.setText("");
//        }
        System.out.println(hostageCount);
    }

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
}

