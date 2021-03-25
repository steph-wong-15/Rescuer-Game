package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.*; //import arraylist

public class Player extends Person{
  double speed;

  double playerShipMinX;
  double playerShipMaxX;
  double playerShipMinY;
  double playerShipMaxY;
  
  ArrayList<String> hostages = new ArrayList<String>(); // Create an ArrayList object that holds strings of possible hostages


  public Player(Image image, Pane layer, int health, int damage, int[][] pos, int[][] size, double x, double y, double r, double dx, double dy, double dr, double speed) {
        super(image, layer, health, damage, pos, size, x, y, r, dx, dy, dr);
        this.speed = speed;
        bounds();
  } 
  private void bounds() {
     // calculate movement bounds of the player
  }

  @Override
    public void move() {

        super.move();

        // ensure the ship can't move outside of the screen
        checkBounds();


    }

    private void checkBounds() {

      // vertical
      if( Double.compare( y, playerShipMinY) < 0) {
         y = playerShipMinY;
      } else if( Double.compare(y, playerShipMaxY) > 0) {
            y = playerShipMaxY;
        }

        // horizontal
        if( Double.compare( x, playerShipMinX) < 0) {
            x = playerShipMinX;
        } else if( Double.compare(x, playerShipMaxX) > 0) {
            x = playerShipMaxX;
        }

    }
  public void damage(Character c){ //class sets damage done
    int enemyDmg = 0; //default damage is 0 
    for (int i = 0; i<hostages.size(); i++){ //iterate through size of hostages
      if (hostages.get(i) == "sword"){
        enemyDmg = 1; //if player holds sword, damage is 1 to enemy players
      }
    }
  }

  public void damageWall(Wall w){ //class sets damage done
    int wallDmg = 0; //default damage is 0 
    for (int i = 0; i<hostages.size(); i++){ //iterate through size of hostages
      if (hostages.get(i) == "axe"){
        wallDmg = 1; //if player holds axe, damage is 1 to BREAKABLE walls
      }
    }
  }

  public void speedUp(float newSpeed){ //import speed
    newSpeed = newSpeed*2; //doubles player speed, useful for getting a better score
  } 

  public void freezeEnemies(){
    //freezeEnemies
  }

  public void sword(){
    //sword
  }

  public void axe(){
    //axe
  } 

}