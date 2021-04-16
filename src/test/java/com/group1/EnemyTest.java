package com.group1;

import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * EnemiesTest Class
 * Tests all the params in Enemies.java to see if all the methods work and values are initialized properly
 * Values must be at the right constants or tests will fail
 */

public class EnemyTest {

    /**
     * EnemiesHealth asserts that getHealth returns the proper goal value of 1, which is true!
     * EnemiesSpeed asserts that getSpeed returns the proper goal value of 2, which is true!
     * EnemiesDamage asserts that getDamage returns the proper goal value of 1, which is true!
     */
    Pane testPane = new Pane();
    Enemies tempEnemies = new Enemies(testPane);

    @Test
    public void enemiesHealthTest() {
        assertEquals(1, tempEnemies.getHealth());
    }
    @Test
    public void enemiesSpeedTest() {
        assertEquals(2, tempEnemies.getSpeed());
    }

    @Test
    public void enemiesDamageTest(){
        assertEquals(1, tempEnemies.getDamageNum());
    }

    @Test
    public void moveTest(){
        double x=tempEnemies.getX();
        double y =tempEnemies.getY();
        tempEnemies.move();
        assertEquals(x+tempEnemies.dx,tempEnemies.getX());
        assertEquals(y+tempEnemies.dy,tempEnemies.getY());
    }

    @Test
    public void addPlayerTest(){
        tempEnemies.addToLayer();
        assert(testPane.getChildren().contains(tempEnemies.imageView));
    }

    @Test
    public void removePlayerTest(){
        tempEnemies.addToLayer();
        assert(testPane.getChildren().contains(tempEnemies.imageView));
        tempEnemies.removeFromLayer();
        assert(!testPane.getChildren().contains(tempEnemies.imageView));
    }

}
