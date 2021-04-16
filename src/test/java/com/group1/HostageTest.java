package com.group1;

import javafx.scene.layout.Pane;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * HostageTest Class
 * Tests all the params in Hostages.java to see if all the methods work and values are initialized properly
 * Values must be at the right constants or tests will fail
 */
public class HostageTest {

/**
 * hostageHealth asserts that getHealth returns the proper goal value of 1 - which is true!)
 */

    Pane testPane = new Pane();
    Hostages tempHostages = new Hostages(testPane);

    @Test
    public void healthTest() {
        assertEquals(1, tempHostages.getHealth());
    }

    @Test
    public void damageTest(){
        assertEquals(0, tempHostages.getDamageNum());
    }

    @Test
    public void damagedHealthTest() {
        tempHostages.getDamaged(); //-1 health
        assertEquals(0, tempHostages.getHealth());
    }

    @Test
    public void speedTest(){
        assertEquals(0,tempHostages.getSpeed());
    }

    @Test
    public void moveTest(){
        double x=tempHostages.getX();
        double y =tempHostages.getY();
        tempHostages.move();
        assertEquals(x+tempHostages.dx,tempHostages.getX());
        assertEquals(y+tempHostages.dy,tempHostages.getY());
    }

    @Test
    public void addPlayerTest(){
        tempHostages.addToLayer();
        assert(testPane.getChildren().contains(tempHostages.imageView));
    }

    @Test
    public void removePlayerTest(){
        tempHostages.addToLayer();
        assert(testPane.getChildren().contains(tempHostages.imageView));
        tempHostages.removeFromLayer();
        assert(!testPane.getChildren().contains(tempHostages.imageView));
    }
}
