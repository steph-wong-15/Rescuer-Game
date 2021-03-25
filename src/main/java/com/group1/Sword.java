package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

class Sword extends Hostages{
  private boolean hasSword; //hasSword
  private int swordDmg; //freezeRange

  public Sword(Image image, Pane layer, int health, int damage, int[][] pos, int[][] size, double x, double y, double r, double dx, double dy, double dr, int[][] lockedPos, String ability, boolean hasSword, int swordDmg) {
        super(image, layer, health, damage, pos, size, x, y, r, dx, dy, dr, lockedPos, ability);
        this.hasSword= hasSword;
        this.swordDmg= swordDmg;

    }

  public int getSwordDamage(){
    return swordDmg;
  }
  public void setSwordDamage(int swordDmg){
    this.swordDmg= swordDmg;
  }
}
