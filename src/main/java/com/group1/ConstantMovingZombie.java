package com.group1;

class ConstantMovingZombie extends Moving{
  private String movementPattern; //possible values: vertical, horizontal, or diagonal

  public ConstantMovingZombie(int health, int[][] pos, int[][] size, double x, double y, double r, double dx, double dy, double dr, int damageDone, int range, String movementPattern) {
        super(health, pos, size, x, y, r, dx, dy, dr,damageDone, range);
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