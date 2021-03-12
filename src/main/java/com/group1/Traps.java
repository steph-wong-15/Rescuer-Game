class Traps extends Enemies{
  private boolean invisible; //set to true or false, sets if the traps are visible to the player or not
  private boolean destroyable; //set to true or false, sets if traps are destroyable with the Axe or not

  public boolean isInvisible(){
    return invisible;
  }
  public boolean isDestroyable(){
    return destroyable;
  }

  public void makeInvisible(boolean invis){
    if (invis == false){
      invis = true; //set visible to parameter to invisible
    }
  }

  public void makeDestroyable(boolean destroy){
    if (destroy == false){
      destroy = true; //set visible to parameter to destroyable
    }
  }
}