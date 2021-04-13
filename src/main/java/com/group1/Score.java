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

/**
 * Score class
 * Keeps track of game score
 */
public class Score {
    boolean end ;
    boolean win;
    int hostageCount;
    Pane layer;
    Player thePlayer;
    Label healthStatus,hostageStatus,endScoreStatus;
    boolean bonus;
    long time,timeUsed,timeLimit;

    /**
     * Constructor for score
     * @param pane Layer that enemies is drawn on
     * @param player Player instance that score is based on
     * @param health Label that shows health status of player
     * @param hostage Label that shows hostage count
     */
    Score(Pane pane, Player player,Label health, Label hostage,Label endScore) {
        layer = pane;
        thePlayer = player;
        healthStatus=health;
        hostageStatus=hostage;
        endScoreStatus=endScore;
        time = System.currentTimeMillis();
        timeLimit=300;// upper bound for how time allowed
    }

        /**
     * Empty constructor used for testing methods
     */
    public Score() {}

    /**
     * Getter for hostageCount
     */
    public int getScore(){
        return hostageCount;
    }
    

    /**
     * Update score for score layer
     */
    public void updateScore() {
        hostageStatus.setText(String.valueOf(hostageCount));
        healthStatus.setText(String.valueOf(thePlayer.getHealth()));
        if(!end){
           timeUsed=(System.currentTimeMillis()-time)/1000;
        }
        if(win){
            if(bonus){
                endScoreStatus.setText(String.valueOf(99999));
            }else {
                endScoreStatus.setText(String.valueOf(2*hostageCount*(timeLimit-timeUsed)));
            }
        }else{
                if(bonus){
                    endScoreStatus.setText(String.valueOf(99*(timeLimit-timeUsed)));
                }else {
                    endScoreStatus.setText(String.valueOf(hostageCount*(timeLimit-timeUsed)));
                }
        }
    }

    /**
     * Increase score
     */
    public void increaseScore() {
        hostageCount++;
    }

    /**
     * Check if winner has all 4 hostages
     * @return true if all hostages are rescued, false otherwise
     */
    public boolean goal() {
        if (hostageCount >= 4) {
            hostageCount = 0;
            return true;
        }
        return false;
    }

    /**
     * Bonus collected
     */
    public void bonusCollected(){
        bonus=true;
    }

    /**
     * Win
     */
    public void win(){
        System.out.println("true");
        win=true;
        end=true;
    }
}


