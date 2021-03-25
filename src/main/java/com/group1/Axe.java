package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

class Axe extends Hostages{
  private boolean hasAxe; //hasAxe
  private int axeDmg; //freezeRange

  public Axe(Image image, Pane layer, int health, int damage, int[][] pos, int[][] size, double x, double y, double r, double dx, double dy, double dr, int[][] lockedPos, String ability, boolean hasAxe, int axeDmg) {
        super(image, layer, health, damage, pos, size, x, y, r, dx, dy, dr, lockedPos, ability);
        this.hasAxe= hasAxe;
        this.axeDmg= axeDmg;

    }

  public int getAxeDamage(){
    return axeDmg;
  }
  public void setAxeDamage(int axeDmg){
    this.axeDmg= axeDmg;
  }
}
