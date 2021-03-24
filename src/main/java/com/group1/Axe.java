package com.group1;

class Axe extends Hostages{
  private boolean hasAxe; //hasAxe
  private int axeDmg; //freezeRange

  public Axe(int health, int[][] pos, int[][] size, double x, double y, double r, double dx, double dy, double dr, int[][] lockedPos, String ability, boolean hasAxe, int axeDmg) {
        super(health, pos, size, x, y, r, dx, dy, dr, lockedPos, ability);
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
