package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.*; //import arraylist

public class Player extends Person{
  double speed;

  double playerMinX;
  double playerMaxX;
  double playerMinY;
  double playerMaxY;

  Input input;

  public Player(Image image, Pane layer, int health, int damage, int[][] pos, int[][] size, double x, double y, double r, double dx, double dy, double dr, double speed, Input input) {
        super(image, layer, health, damage, pos, size, x, y, r, dx, dy, dr);
        this.input = input;
        this.speed = speed;
        bounds();
  } 
  private void bounds() {
    playerMinX = 0 - image.getWidth() / 2.0;
    playerMaxX = Settings.SCENE_WIDTH - image.getWidth() / 2.0;
    playerMinY = 0 - image.getHeight() / 2.0;
    playerMaxY = Settings.SCENE_HEIGHT -image.getHeight() / 2.0;
  }

  @Override
    public void move() {

        super.move();

        // ensure the player can't move outside of the screen
        checkBounds();

    }

    private void checkBounds() {

      // vertical
      if (Double.compare(y, playerMinY) < 0) {
        y = playerMinY;
      } else if (Double.compare(y, playerMaxY) > 0) {
        y = playerMaxY;
      }

      // horizontal
      if (Double.compare(x, playerMinX) < 0) {
        x = playerMinX;
      } else if (Double.compare(x, playerMaxX) > 0) {
        x = playerMaxX;
      }

    }


  public void processInput() {
    // up and down
    if( input.isMoveUp()) {
      dy = -speed;
    } else if( input.isMoveDown()) {
      dy = speed;
    } else { //if no input set speed to zero
      dy = 0.0;
    }

    // left and right
    if( input.isMoveLeft()) {
      dx = -speed;
    } else if( input.isMoveRight()) {
      dx = speed;
    } else { //if no input set speed to zero
      dx = 0.0;
    }
  }
  public void checkRemovability() { //override in case things go wrong
  }

  public void speedUp(double newSpeed){ //import speed
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