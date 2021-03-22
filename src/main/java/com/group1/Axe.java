package com.group1;

class Axe extends Hostages{
  private boolean hasAxe; //hasAxe
  private int axeDmg; //freezeRange

  public Axe(int health, int[][] pos, int[][] size, float speed, int[][] lockedPos, String ability, boolean hasAxe, int axeDmg) {
        super(health, pos, size, speed, lockedPos, ability);
        this.hasAxe= hasAxe;
        this.axeDmg= axeDmg;

    }

  public int getAxeDamage(){
    return axeDmg;
  }
  public void setAxeDamage(int axeDmg){
    this.axeDmg= axeDmg;
  }
}
