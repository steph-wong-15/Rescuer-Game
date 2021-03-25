package com.group1;


import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

class Projectile extends Moving{
  private String direction; //set to left, right, up, or down 
  private int frequency; //sets the timing interval of when projectiles come out (ex: 1s, 2s, 5s, etc.)

  public Projectile(Image image, Pane layer, int health, int damage,  double x, double y, double r, double dx, double dy, double dr, int damageDone, int range, String direction, int frequency) {
        super(image, layer, health, damage, x, y, r, dx, dy, dr, damageDone, range);
    this.direction = direction;
        this.frequency = frequency;
  }

  public String getDirection(){ //getter
    return direction;
  }
  public void setDirection(String newDirection){ //setter
    this.direction= newDirection;
  }

  public int getFrequency(){ //getter
    return frequency;
  }
  public void setFrequency(int newFrequency){
    this.frequency = newFrequency;
  }

  public void shoot(){ //shoot method 
    // ArrayList<Rectangle> projectiles = new ArrayList();
    // Iterator<Rectangle> object = projectiles.object();
    if (direction=="left"){ //if left shoot left
      
    }
    else if (direction=="right"){ //if right shoot right
      
    }
    else if (direction=="up"){ //if up shoot up
      
    }
    else if (direction=="down"){ //if down shoot down
      
    }
    else { //if direction is not equal to left, right, up or down, remove projectile 
      // projectiles.remove(i);
    }
}
}