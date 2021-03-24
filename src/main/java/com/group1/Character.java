package com.group1;

public abstract class Character{ 
  private int health;
  private int[][] pos;
  private int[][] size;

  double x;
  double y;
  double r;

  double dx;
  double dy;
  double dr;
  
  boolean canMove = true;
  boolean removable = false;
  public Character(int health, int[][] pos, int[][] size, double x, double y, double r, double dx, double dy, double dr) {
        this.health = health;
        this.pos= pos;
        this.size = size;

        this.x = x;
        this.y = y;
        this.r = r;
        this.dx = dx;
        this.dy = dy;
        this.dr = dr;
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
    if( !canMove)
            return;

        x += dx;
        y += dy;
        r += dr;
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

  public void draw(){
    //implement a drawing function
  }
  //extra setters and getters
  public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getDr() {
        return dr;
    }

    public void setDr(double dr) {
        this.dr = dr;
    }
    //kill player
    public void kill() {
        setHealth(0);
    }

    public boolean isRemovable() { //getter for removable
        return removable;
    }

    public void setRemovable(boolean removable) {
        this.removable = removable;
    }

    public void checkRemovability() {
        //default
    }
}