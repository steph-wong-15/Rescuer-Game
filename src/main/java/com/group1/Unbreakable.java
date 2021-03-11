package com.group1;

public class Unbreakable extends Wall{

    private boolean boundaryWall;

    public Unbreakable(int[][] size, String colour, boolean passable, int[][] location, boolean boundaryWall) {
        super(size, colour, passable, location);
        this.boundaryWall = boundaryWall;
    }

    public boolean isBoundaryWall() {
        return boundaryWall;
    }

    public void setBoundaryWall(boolean boundaryWall) {
        this.boundaryWall = boundaryWall;
    }

}
