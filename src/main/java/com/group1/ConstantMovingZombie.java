class ConstantMovingZombie extends Moving{
  private String movementPattern; //possible values: vertical, horizontal, or diagonal

  //return the damageDone
  public String getMovementPattern() {
    return movementPattern;
  }

  //set the damageDone
  public void setMovementPattern(String newMovementPattern){
    this.movementPattern = newMovementPattern;
  }
}