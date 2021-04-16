package com.group1;

import javafx.scene.layout.Pane;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Random;

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

    @Test
    public void EnemyCollisionTest(){
        Enemies enemy= new Enemies(testPane);
        int rndX= new Random().nextInt((int)Settings.SCENE_WIDTH);
        int rndY= new Random().nextInt((int)Settings.SCENE_HEIGHT);
        tempPlayer.setX(rndX);
        tempPlayer.setY(rndY);
        enemy.setX(rndX);
        enemy.setY(rndY);
        assert(tempPlayer.CharacterCollision(enemy));
    }

    @Test
    public void HostageCollisionTest(){
         Hostages hostage =new Hostages(testPane);
        int rndX= new Random().nextInt((int)Settings.SCENE_WIDTH);
        int rndY= new Random().nextInt((int)Settings.SCENE_HEIGHT);
        tempPlayer.setX(rndX);
        tempPlayer.setY(rndY);
        hostage.setX(rndX);
        hostage.setY(rndY);
        assert(tempPlayer.CharacterCollision(hostage));
    }

    @Test
    public void BonusCollisionTest(){
        Bonus bonus =new Bonus(testPane);
        int rndX= new Random().nextInt((int)Settings.SCENE_WIDTH);
        int rndY= new Random().nextInt((int)Settings.SCENE_HEIGHT);
        tempPlayer.setX(rndX);
        tempPlayer.setY(rndY);
        bonus.setX(rndX);
        bonus.setY(rndY);
        assert(tempPlayer.CharacterCollision(bonus));
    }

    @Test
    public void GoalCollisionTest(){
        Goal goal =new Goal(testPane);
        int rndX= new Random().nextInt((int)Settings.SCENE_WIDTH);
        int rndY= new Random().nextInt((int)Settings.SCENE_HEIGHT);
        tempPlayer.setX(rndX);
        tempPlayer.setY(rndY);
        goal.setX(rndX);
        goal.setY(rndY);
        assert(tempPlayer.CharacterCollision(goal));
    }
}
