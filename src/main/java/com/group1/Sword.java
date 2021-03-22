package com.group1;

class Sword extends Hostages{
  private boolean hasSword; //hasSword
  private int swordDmg; //freezeRange

  public Sword(int health, int[][] pos, int[][] size, float speed, int[][] lockedPos, String ability, boolean hasSword, int swordDmg) {
        super(health, pos, size, speed, lockedPos, ability);
        this.hasSword= hasSword;
        this.swordDmg= swordDmg;

    }

  public int getSwordDamage(){
    return swordDmg;
  }
  public void setSwordDamage(int swordDmg){
    this.swordDmg= swordDmg;
  }
}
