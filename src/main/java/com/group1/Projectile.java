class Projectile extends Moving{
  private String direction; //set to left, right, up, or down 
  private int frequency; //sets the timing interval of when projectiles come out (ex: 1s, 2s, 5s, etc.)

  public String getDirection(){ //getter
    return direction;
  }
  public void setDirection(String newDirection){ //setter
    this.direction= newDirection;
  }

  public int getFrequency(){ //getter
    return frequency;
  }
  public void setFrequency(int newFrequency){
    this.frequency = newFrequency;
  }

  // public void shoot(){ //fix later, need to think about which modules to import 
  //   if (direction=="left"){
      
  //   }
  //   if (direction=="right"){
      
  //   }
  //   if (direction=="up"){
      
  //   }
  //   if (direction=="down"){
      
  //   }
  // }
}