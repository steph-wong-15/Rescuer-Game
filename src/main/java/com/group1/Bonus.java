package com.group1;

class Bonus extends Hostages{
  private int reward; //reward

  public Bonus(int health, int[][] pos, int[][] size, float speed, double x, double y, double r, double dx, double dy, double dr, int[][] lockedPos, String ability, int reward) {
        super(health, pos, size, speed, x, y, r, dx, dy, dr, lockedPos, ability);
        this.reward = reward;

    }

  public int getReward(){
    return reward;
  }

  public void setReward(int reward){
    this.reward = reward;
  }
}
