package com.group1;

class ConstantMovingZombie extends Moving{
  private String movementPattern; //possible values: vertical, horizontal, or diagonal

  public ConstantMovingZombie(int health, int[][] pos, int[][] size, float speed, int damageDone, int range, String movementPattern) {
        super(health, pos, size, speed, damageDone, range);
        this.movementPattern = movementPattern;
  }

  //return the damageDone
  public String getMovementPattern() {
    return movementPattern;
  }

  //set the damageDone
  public void setMovementPattern(String newMovementPattern){
    this.movementPattern = newMovementPattern;
  }
}