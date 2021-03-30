package com.group1;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    int hostageCount;
    Text collisionText;
    Pane layer;
    Player thePlayer;
    Label healthStatus,hostageStatus;
    Score(Pane pane, Player player,Label health, Label hostage) {
        layer = pane;
        thePlayer = player;
        healthStatus=health;
        hostageStatus=hostage;
        createScoreLayer();
    }

    /**
     * Layer that displays text when events occur
     */
    private void createScoreLayer() {
        collisionText = new Text();
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
        hostageStatus.setText(String.valueOf(hostageCount));
        healthStatus.setText(String.valueOf(thePlayer.getHealth()));
//        if (hostageCollision && hostageCount < 4) {
//            collisionText.setFill(Color.GREEN);
//            collisionText.setStroke(Color.GREEN);
//            collisionText.setText("Hostaged rescued. \nNicely done!");
//            collisionText.setFill(Color.RED);
//            collisionText.setStroke(Color.BLACK);
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
    }

    /**
     * Increase score
     */
    public void increaseScore() {
        hostageCount++;
    }

    /**
     * Check if winner has all 4 hostages
     *
     * @return true if all hostages are rescued, false otherwise
     */
    public boolean goal() {
        if (hostageCount >= 4) {
            hostageCount = 0;
            return true;
        }
        return false;
    }
}


