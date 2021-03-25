package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.Random;

class Moving extends Enemies{
  private int range; //sets the range of the enemy movement

  public Moving(Image image, Pane layer, int health, int damage,  double x, double y, double r, double dx, double dy, double dr, int damageDone, int range) {
        super(image, layer, health, damage, x, y, r, dx, dy, dr);
        this.range = range;
  }

  public int getRange(){ //getter
    return range; 
  }

  public void setRange(int newRange){ //setter
    this.range = newRange;
  }

  public void changeSpeed(int newSpeed){ //change the speed of a random enemy type
    if (newSpeed <= 5 && newSpeed>0){ 
      Random rand = new Random(); 
      newSpeed = rand.nextInt(5) + 1; //set speed from 1-5 inclusive 
    }
    if (newSpeed < 10 && newSpeed>0){
      Random rand = new Random(); 
      newSpeed = rand.nextInt(10) + 1; //set speed from 1-10 inclusive 

      //what this means is over time, enemies will grow on *average* more slow over a long period of time,giving an easier difficulty curve if newer players choose to take their time
    }
  }
}