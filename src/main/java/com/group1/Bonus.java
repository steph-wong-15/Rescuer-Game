package com.group1;

class Bonus extends Hostages{
  private int reward; //reward

  public Bonus(int health, int[][] pos, int[][] size, float speed, int[][] lockedPos, String ability, int reward) {
        super(health, pos, size, speed, lockedPos, ability);
        this.reward = reward;

    }

  public int getReward(){
    return reward;
  }

  public void setReward(int reward){
    this.reward = reward;
  }
}
