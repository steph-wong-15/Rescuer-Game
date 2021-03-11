package com.group1;

public class Door extends Wall{

    private boolean keyRequired;
    private boolean opened;

    public Door(int[][] size, String colour, boolean passable, int[][] location, boolean keyRequired) {
        super(size, colour, passable, location);
        this.keyRequired = keyRequired;
    }

    //public void open() {
        //if (key == true ) {
        //opened = true;
         //}
   // }

    public boolean isKeyRequired() {
        return keyRequired;
    }

    public void setKeyRequired(boolean keyRequired) {
        this.keyRequired = keyRequired;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

}
