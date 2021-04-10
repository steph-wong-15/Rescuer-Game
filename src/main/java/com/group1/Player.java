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
  Input input;

  private Player(Image image, Pane layer, double x, double y, Input input) {
        super(image, layer, x, y);
        this.input = input;
        speed=Settings.PLAYER_SPEED;
        health=Settings.PLAYER_HEALTH;
        damage=1;
  }

  /**
   * Make player instance
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
    return new Player(image, pane, x, y, input);
  }
  
  /**
   * PLayer movement and edge detection
   */
  @Override
  public void move() {
    super.move();
    checkBounds();
  }

  /**
   * Takes player input for controls
   */
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

}