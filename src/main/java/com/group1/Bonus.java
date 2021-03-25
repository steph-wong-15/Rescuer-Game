package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

class Bonus extends Hostages{
  private int reward; //reward

  public Bonus(Image image, Pane layer, int health, int damage,  double x, double y, double r, double dx, double dy, double dr, String name, int reward) {
        super(image, layer, health, damage,  x, y, r, dx, dy, dr, name);
        this.reward = reward;

    }

  public int getReward(){
    return reward;
  }

  public void setReward(int reward){
    this.reward = reward;
  }
}
