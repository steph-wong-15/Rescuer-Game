package com.group1;

public abstract class Wall {

    private int[][] size;
    private String colour;
    private boolean passable;
    private int[][] location;

    public Wall(int[][] size, String colour, boolean passable, int[][] location) {
        this.size = size;
        this.colour = colour;
        this.passable = passable;
        this.location = location;
    }

    public int[][] getSize() {
        return size;
    }

    public void setSize(int[][] size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isPassable() {
        return passable;
    }

    public void setPassable(boolean passable) {
        this.passable = passable;
    }

    public int[][] getLocation() {
        return location;
    }

    public void setLocation(int[][] location) {
        this.location = location;
    }


}
