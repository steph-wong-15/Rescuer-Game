package com.group1;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class Score {
    boolean hostageCollision = false; //hostage collision
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
     * Update score for score layer
     */
    public void updateScore() {
        if (hostageCollision && hostageCount < 4) {
            collisionText.setFill(Color.GREEN);
            collisionText.setStroke(Color.GREEN);
            collisionText.setText("Hostaged rescued. \nNicely done!");
            collisionText.setFill(Color.RED);
            collisionText.setStroke(Color.BLACK);
//        }else if (hostageCount==4) {
//            collisionText.setText("You saved four hostages!\n Go back to start!");
//            createGoal();
//        }
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
    }

    /**
     * Increase score
     */
    public void increaseScore() {
        hostageCount++;
    }
    public boolean goal(){
        if(hostageCount>=4){
            hostageCount=0;
            return true;
        }
        return false;
    }

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
}

