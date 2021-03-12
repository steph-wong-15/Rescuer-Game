abstract class Character{ //IMPORTANT: still needs work, did not implement vectors yet and half the modules; fixing next week 
  private int health;

  private float speed;

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

  public void draw(){
    //implement a drawing function
  }

}