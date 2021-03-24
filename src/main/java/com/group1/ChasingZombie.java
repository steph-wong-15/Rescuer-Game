package com.group1;

class ChasingZombie extends Moving{
  private boolean weapon; //holds weapon type boolean
  
  public ChasingZombie(int health, int[][] pos, int[][] size, float speed, double x, double y, double r, double dx, double dy, double dr, int damageDone, int range, boolean weapon) {
        super(health, pos, size, speed, x, y, r, dx, dy, dr, damageDone, range);
        this.weapon = weapon;
  }

  public boolean getWeapon(){ //getter
    return weapon;
  }
  public void setWeapon(boolean newWeapon){ //setter
    this.weapon = newWeapon;
  }

  public void followPlayer(){
    //implement
  }
}
