package com.group1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * GoalTest Class
 * Tests all the params in Goal.java to see if all the methods work and values are initialized properly
 * Values must be at the right constants or tests will fail
 */
class GoalTest {

    /**
     * goalHealth asserts that getHealth returns the proper goal value of 1 - which is true!)
     * ScoreGoalTestWorks asserts that if we run getDamaged, and Goal gets removed, it decrements health by 1 for our Main
     */
    Goal tempGoal = new Goal();

    @Test
    void goalHealthTest() {
        assertEquals(1, tempGoal.getHealth());
    }

    @Test
    void goalDamagedTest() {
        tempGoal.getDamaged();
        assertEquals(0, tempGoal.getHealth());
    }
}