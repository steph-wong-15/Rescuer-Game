package com.group1;

import javafx.scene.layout.Pane;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * PlayerTest Class
 * Tests all the params in Player.java to see if all the methods work and values are initialized properly
 * Values must be at the right constants (Settings values!) or tests will fail
 */

public class PlayerTest {

    /**
     * PlayerHealth asserts that getHealth returns the proper goal value of PLAYER_HEALTH, a settings value - which is true!
     * PlayerSpeed asserts that getSpeed returns the proper goal value of PLAYER_SPEED, a settings value - which is true!)
     * PlayerDamage asserts that getDamage returns the proper goal value of 1, which is true!)
     */

    Pane testPane = new Pane();
    Player tempPlayer = new Player(testPane);

    @Test
    public void healthTest() {
        assertEquals(Settings.PLAYER_HEALTH, tempPlayer.getHealth());
    }

    @Test
    public void speedTest() {
        assertEquals(Settings.PLAYER_SPEED, tempPlayer.getSpeed());
    }

    @Test
    public void damageTest(){
        assertEquals(1, tempPlayer.getDamageNum());
    }

    @Test
    public void damagedHealthTest() {
        int damageHealth= tempPlayer.getHealth()-1;
        tempPlayer.getDamaged(); //-1 health
        assertEquals(damageHealth, tempPlayer.getHealth());
    }

    @Test
    public void moveTest(){
        double x=tempPlayer.getX();
        double y =tempPlayer.getY();
        tempPlayer.move();
        assertEquals(x+tempPlayer.dx,tempPlayer.getX());
        assertEquals(y+tempPlayer.dy,tempPlayer.getY());
    }

    @Test
    public void addPlayerTest(){
        tempPlayer.addToLayer();
        assert(testPane.getChildren().contains(tempPlayer.imageView));
    }

    @Test
    public void removePlayerTest(){
        tempPlayer.addToLayer();
        assert(testPane.getChildren().contains(tempPlayer.imageView));
        tempPlayer.removeFromLayer();
        assert(!testPane.getChildren().contains(tempPlayer.imageView));
    }

}
