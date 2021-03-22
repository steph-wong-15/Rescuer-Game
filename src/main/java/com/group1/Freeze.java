package com.group1;

class Freeze extends Hostages{
  private int freezeDuration; //freezeDuration
  private int freezeRange; //freezeRange

  public Freeze(int health, int[][] pos, int[][] size, float speed, int[][] lockedPos, String ability, int freezeDuration, int freezeRange) {
        super(health, pos, size, speed, lockedPos, ability);
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
