package com.group1;

class Freeze extends Hostages{
  private int freezeDuration; //freezeDuration
  private int freezeRange; //freezeRange

  public Freeze(int health, int[][] pos, int[][] size, int[][] lockedPos, String ability, double x, double y, double r, double dx, double dy, double dr, int freezeDuration, int freezeRange) {
        super(health, pos, size, x, y, r, dx, dy, dr, lockedPos, ability);
        this.freezeDuration = freezeDuration;
        this.freezeRange = freezeRange;

    }

  public int getFreezeDuration(){
    return freezeDuration;
  }
  public void setFreezeDuration(int freezeDuration){
    this.freezeDuration= freezeDuration;
  }

  public int getFreezeRange(){
    return freezeRange;
  }
  public void setFreezeRange(int freezeRange){
    this.freezeRange= freezeRange;
  }
}
