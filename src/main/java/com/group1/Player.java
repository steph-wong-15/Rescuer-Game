package com.group1;

import java.util.ArrayList; // import the ArrayList class

class Player extends Character{
  public ArrayList<String> hostages = new ArrayList<String>(); // Create an ArrayList object that holds strings of possible hostages

  public Player(int health, int[][] pos, int[][] size, float speed) {
        super(health, pos, size, speed);
  }
  // public void followPlayer(){
    //unneeded
  // }


  public void damage(Character c){ //class sets damage done
    int enemyDmg = 0; //default damage is 0 
    for (int i = 0; i<hostages.size(); i++){ //iterate through size of hostages
      if (hostages.get(i) == "sword"){
        enemyDmg = 1; //if player holds sword, damage is 1 to enemy players
      }
    }
  }

  public void damageWall(Wall w){ //class sets damage done
    int wallDmg = 0; //default damage is 0 
    for (int i = 0; i<hostages.size(); i++){ //iterate through size of hostages
      if (hostages.get(i) == "axe"){
        wallDmg = 1; //if player holds axe, damage is 1 to BREAKABLE walls
      }
    }
  }

  public void speedUp(float newSpeed){ //import speed
    newSpeed = newSpeed*2; //doubles player speed, useful for getting a better score
  } 

  public void freezeEnemies(){
    //freezeEnemies
  }

  public void sword(){
    //sword
  }

  public void axe(){
    //axe
  } 

}