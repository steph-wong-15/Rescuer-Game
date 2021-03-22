package com.group1;

class Traps extends Enemies{
  private boolean invisible; //set to true or false, sets if the traps are visible to the player or not
  private boolean destroyable; //set to true or false, sets if traps are destroyable with the Axe or not

  public Traps(int health, int[][] pos, int[][] size, float speed, int damageDone, boolean invisible, boolean destroyable) {
        super(health, pos, size, speed, damageDone);
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