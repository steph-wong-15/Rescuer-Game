package com.group1;

abstract class Character{ 
  private int health;
  private int[][] pos;
  private int[][] size;
  private float speed;
  
  public Character(int health, int[][] pos, int[][] size, float speed) {
        this.health = health;
        this.pos= pos;
        this.speed = speed;
        this.size = size;
    }

  //return the health
  public int getHealth() {
    return health;
  }

  //set the damageDone
  public void setHealth(int newHealth){
    this.health = newHealth;
  } 

  public void move(){
    //implement moving
  }
  public void characterCollision(Character c){
    //implement characterCollision
  }
  public void wallCollision(Wall w){
    //implement wallCollision
  }

  public int[][] getPos() {
      return pos;
  }

  public void setPos(int[][] pos) {
      this.pos = pos;
  }


  public int[][] getSize() {
        return size;
    }

  public void setSize(int[][] size) {
      this.size = size;
  }

  public float getSpeed() {
    return speed;
  }

  //set the damageDone
  public void setSpeed(float speed){
    this.speed = speed;
  } 

  public void draw(){
    //implement a drawing function
  }
  
}