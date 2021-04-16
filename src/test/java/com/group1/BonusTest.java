package com.group1;

import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusTest {

    Pane testPane = new Pane();
    Bonus tempBonus = new Bonus(testPane);

    @Test
    public void healthTest() {
        assertEquals(1, tempBonus.getHealth());
    }

    @Test
    public void damageTest(){
        assertEquals(0, tempBonus.getDamageNum());
    }

    @Test
    public void damagedHealthTest() {
        tempBonus.getDamaged(); //-1 health
        assertEquals(0, tempBonus.getHealth());
    }

    @Test
    public void speedTest(){
        assertEquals(0,tempBonus.getSpeed());
    }

    @Test
    public void moveTest(){
        double x=tempBonus.getX();
        double y =tempBonus.getY();
        tempBonus.move();
        assertEquals(x+tempBonus.dx,tempBonus.getX());
        assertEquals(y+tempBonus.dy,tempBonus.getY());
    }

    @Test
    public void addPlayerTest(){
        tempBonus.addToLayer();
        assert(testPane.getChildren().contains(tempBonus.imageView));
    }

    @Test
    public void removePlayerTest(){
        tempBonus.addToLayer();
        assert(testPane.getChildren().contains(tempBonus.imageView));
        tempBonus.removeFromLayer();
        assert(!testPane.getChildren().contains(tempBonus.imageView));
    }
}
