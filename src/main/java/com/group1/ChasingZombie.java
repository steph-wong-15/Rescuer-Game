package com.group1;

class ChasingZombie extends Moving{
  private boolean weapon; //holds weapon type boolean
  
  public ChasingZombie(int health, int[][] pos, int[][] size, float speed, int damageDone, int range, boolean weapon) {
        super(health, pos, size, speed, damageDone, range);
        this.weapon = weapon;
  }

  public boolean getWeapon(){ //getter
    return weapon;
  }
  public void setWeapon(boolean newWeapon){ //setter
    this.weapon = newWeapon;
  }

  public void followPlayer(){
    
  }
}
