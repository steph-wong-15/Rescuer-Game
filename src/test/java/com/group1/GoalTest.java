package com.group1;

import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * GoalTest Class
 * Tests all the params in Goal.java to see if all the methods work and values are initialized properly
 * Values must be at the right constants or tests will fail
 */
public class GoalTest {

    /**
     * goalHealth asserts that getHealth returns the proper goal value of 1 - which is true!)
     * ScoreGoalTestWorks asserts that if we run getDamaged, and Goal gets removed, it decrements health by 1 for our Main
     */
    Pane testPane = new Pane();
    Goal tempGoal = new Goal(testPane);

    @Test
    public void goalHealthTest() {
        assertEquals(1, tempGoal.getHealth());
    }

    @Test
    public void goalDamagedTest() {
        tempGoal.getDamaged();
        assertEquals(0, tempGoal.getHealth());
    }

    @Test
    public void moveTest(){
        double x=tempGoal.getX();
        double y =tempGoal.getY();
        tempGoal.move();
        assertEquals(x+tempGoal.dx,tempGoal.getX());
        assertEquals(y+tempGoal.dy,tempGoal.getY());
    }

    @Test
    public void addPlayerTest(){
        tempGoal.addToLayer();
        assert(testPane.getChildren().contains(tempGoal.imageView));
    }

    @Test
    public void removePlayerTest(){
        tempGoal.addToLayer();
        assert(testPane.getChildren().contains(tempGoal.imageView));
        tempGoal.removeFromLayer();
        assert(!testPane.getChildren().contains(tempGoal.imageView));
    }

}