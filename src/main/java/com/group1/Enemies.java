package com.group1;

class Enemies extends Character{
  private int damageDone;

  public Enemies(int health, int[][] pos, int[][] size, double x, double y, double r, double dx, double dy, double dr, int damageDone) {
        super(health, pos, size, x, y, r, dx, dy, dr);
        this.damageDone = damageDone;
    }
  //return the damageDone
  public int getDamageDone() {
    return damageDone;
  }

  //set the damageDone
  public void setDamageDone(int damageDone){
    this.damageDone = damageDone;
  }

  public void checkRemovability() {
        //default
        if( Double.compare( getY(), Settings.SCENE_HEIGHT) > 0) {
            setRemovable(true);
        }
  }
}