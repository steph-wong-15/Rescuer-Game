package com.group1;

public class Exit extends Wall{

    private boolean hostageRequired;

    public Exit(int[][] size, String colour, boolean passable, int[][] location, boolean hostageRequired) {
        super(size, colour, passable, location);
        this.hostageRequired = hostageRequired;
    }

    //public void open() {
    //if (hostageRequired == true ) {
    //opened = true;
    //}
    // }

    public boolean isHostageRequired() {
        return hostageRequired;
    }

    public void setHostageRequired(boolean hostageRequired) {
        this.hostageRequired = hostageRequired;
    }

}
