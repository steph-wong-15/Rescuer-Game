package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

class Freeze extends Hostages{
  private int freezeDuration; //freezeDuration
  private int freezeRange; //freezeRange

  public Freeze(Image image, Pane layer, int health, int damage, int[][] pos, int[][] size, double x, double y, double r, double dx, double dy, double dr, int[][] lockedPos, String ability, int freezeDuration, int freezeRange) {
        super(image, layer, health, damage, pos, size, x, y, r, dx, dy, dr, lockedPos, ability);
        this.freezeDuration = freezeDuration;
        this.freezeRange = freezeRange;

    }

  public int getFreezeDuration(){
    return freezeDuration;
  }
  public void setFreezeDuration(int freezeDuration){
    this.freezeDuration= freezeDuration;
  }

  public int getFreezeRange(){
    return freezeRange;
  }
  public void setFreezeRange(int freezeRange){
    this.freezeRange= freezeRange;
  }
}
