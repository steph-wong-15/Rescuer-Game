package com.group1;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.*; //import arraylist

/**
 * Player Class
 * Extends off the Person class to generate the main character
 */

public class Player extends Person{
  double speed;

  double playerMinX;
  double playerMaxX;
  double playerMinY;
  double playerMaxY;

  Input input;

  private Player(Image image, Pane layer, int health, int damage, double x, double y, double r, double dx, double dy, double dr, double speed, Input input) {
        super(image, layer, health, damage, x, y, r, dx, dy, dr);
        this.input = input;
        this.speed = speed;
        bounds();
  }

  /**
   * Make player
   */
  public static Player createPlayer(Pane pane) {
    //image
    Image image = Main.playerImage;
    // player input
    Input input = new Input(pane.getScene()); //use temporary scene var

    // register input listeners
    input.addListeners();

    // center horizontally, position at 70% vertically
    double x = (Settings.SCENE_WIDTH - image.getWidth()) / 2.0;
    double y = Settings.SCENE_HEIGHT * 0.7;

    // create player
    return new Player(image, pane, Settings.PLAYER_HEALTH, 0, x, y, 0, 0, 0, 0, Settings.PLAYER_SPEED, input);
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

  public double speedUp(double speed){ //import speed
    speed = speed*2.0; //doubles player speed, useful for getting a better score
    return speed;
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