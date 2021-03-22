package com.group1;

import java.util.Arrays;  //import Arrays class

class Hostages extends Character{
  private int[][] lockedPos; //lockedPosition
  private String ability; //ability


  public Hostages(int health, int[][] pos, int[][] size, float speed, int[][] lockedPos, String ability) {
        super(health, pos, size, speed); 
        this.lockedPos = lockedPos;
        this.ability = ability;    
  }

  public void returnToLocked(int[][] currentPos){
   for( int i = 0, j=0; i*j < currentPos.length; i++, j++)
      currentPos[i] = lockedPos[i]; //set current position to locked position 
  }

  public String getAbility(){
    return ability;
  }

  public void setAbility(String ability){
    this.ability = ability;
  }

}