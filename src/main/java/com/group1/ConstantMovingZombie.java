package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

class ConstantMovingZombie extends Moving{
  private String movementPattern; //possible values: vertical, horizontal, or diagonal

  public ConstantMovingZombie(Image image, Pane layer, int health, int damage, int[][] pos, int[][] size, double x, double y, double r, double dx, double dy, double dr, int damageDone, int range, String movementPattern) {
        super(image, layer, health, damage, pos, size, x, y, r, dx, dy, dr, damageDone, range);
        this.movementPattern = movementPattern;
  }

  //return the damageDone
  public String getMovementPattern() {
    return movementPattern;
  }

  //set the damageDone
  public void setMovementPattern(String newMovementPattern){
    this.movementPattern = newMovementPattern;
  }
}