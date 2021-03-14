package com.group1;

public class Breakable extends Wall{

    private int durability;
    private boolean destroyed;

    public Breakable(int[][] size, String colour, boolean passable, int[][] location, int durability) {
        super(size, colour, passable, location);
        this.durability = durability;
    }

    public void destroy() {
        destroyed = true;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

}
