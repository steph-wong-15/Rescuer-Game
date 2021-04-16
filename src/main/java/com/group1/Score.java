package com.group1;

import javafx.scene.control.Label;
import javafx.scene.layout.*;

/**
 * Score class
 * Keeps track of game score
 */
public class Score {
    boolean end;
    boolean win;
    int hostageCount;
    Pane layer;
    Player thePlayer;
    Label healthStatus,hostageStatus,endScoreStatus;
    boolean bonus;
    long time,timeUsed,timeLimit,scoreTime;
    long endScore;

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
        timeLimit=Settings.TIME_LIMIT;// upper bound for how time allowed
    }

    /**
     * Constructor used for testing methods (doesn't have pane)
     */
    public Score() {
        timeLimit=Settings.TIME_LIMIT;// upper bound for how time allowed
    }

    /**
     * Getter for hostageCount
     */
    public int getHostageCount(){
        return hostageCount;
    }

    /**
     * Getter for boolean end variable
     */
    public boolean getEnd(){
        return end;
    }

    /**
     * Getter for boolean win variable
     */
    public boolean getWin(){
        return win;
    }

    /**
     * Setter for boolean win variable
     */
    public void setEnd(boolean end) {
        this.end = end;
    }

    /**
     * Setter for boolean win variable
     */
    public void setWin(boolean win) {
        this.win = win;
    }

    /**
     * Setter for hostageCount
     * @param hostageCount number of hostages
     */
    public void setHostageCount(int hostageCount) {
        this.hostageCount = hostageCount;
    }

    /**
     * Update score for score layer
     */
    public void updateScore() {
        hostageStatus.setText(String.valueOf(hostageCount));
        healthStatus.setText(String.valueOf(thePlayer.getHealth()));
        endScoreStatus.setText(String.valueOf(calculateScore()));
    }

    /**
     * Calculate Score
     */
    public long calculateScore(){
        if(!end){
            timeUsed=(System.currentTimeMillis()-time)/1000;
        }
        scoreTime=Math.max(0,timeLimit-timeUsed); //Make score is not negative
        if(win){
            if(bonus){
                endScore=5000+10*(scoreTime);
            }else {
                endScore=4000+10*(scoreTime);
            }
        }else{
            if(bonus){
                endScore=99*(scoreTime);
            }else {
                endScore=hostageCount*(scoreTime);
            }
        }
        return endScore;
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
        win=true;
        end=true;
    }

    /**
     * Set timeUsed (testing purposes)
     */
    public void setTimeUsed(int t){
        timeUsed=t;
    }

    /**
     * Get ending score
     */
    public long getEndScore(){
        return endScore;
    }
}


