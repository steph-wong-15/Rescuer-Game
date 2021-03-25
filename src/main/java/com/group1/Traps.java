package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

class Traps extends Enemies{
  private boolean invisible; //set to true or false, sets if the traps are visible to the player or not
  private boolean destroyable; //set to true or false, sets if traps are destroyable with the Axe or not

  public Traps(Image image, Pane layer, int health, int damage, int[][] pos, int[][] size, double x, double y, double r, double dx, double dy, double dr, int damageDone, boolean invisible, boolean destroyable) {
        super(image, layer, health, damage, pos, size, x, y, r, dx, dy, dr);
        this.invisible = invisible;
        this.destroyable = destroyable;

    }

  public boolean isInvisible(){
    return invisible;
  }
  public boolean isDestroyable(){
    return destroyable;
  }

  public void makeInvisible(boolean invis){
    if (invis == false){
      invis = true; //set visible to parameter to invisible
    }
  }

  public void makeDestroyable(boolean destroy){
    if (destroy == false){
      destroy = true; //set visible to parameter to destroyable
    }
  }
}