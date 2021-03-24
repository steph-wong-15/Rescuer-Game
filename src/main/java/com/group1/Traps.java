package com.group1;

class Traps extends Enemies{
  private boolean invisible; //set to true or false, sets if the traps are visible to the player or not
  private boolean destroyable; //set to true or false, sets if traps are destroyable with the Axe or not

  public Traps(int health, int[][] pos, int[][] size, double x, double y, double r, double dx, double dy, double dr, int damageDone, boolean invisible, boolean destroyable) {
        super(health, pos, size, x, y, r, dx, dy, dr, damageDone);
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