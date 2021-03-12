class ChasingZombie extends Moving{
  private boolean weapon;
  //this class almost certainly needs more implementation, this is just UML implementation
  public boolean getWeapon(){ //getter
    return weapon;
  }
  public void setWeapon(boolean newWeapon){ //setter
    this.weapon = newWeapon;
  }
}