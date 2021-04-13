package com.group1;

import javafx.scene.image.Image;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * PlayerSettingsTest Class
 * Tests all the params in Settings.java to see if they are the right values
 * Values must be at the right constants or tests will fail
 */
class PlayerSettingsTest{

    private final double widthCheck = Settings.SCENE_WIDTH;
    private final double heightCheck = Settings.SCENE_HEIGHT;
    private final double speedCheck = Settings.PLAYER_SPEED;
    private final int healthCheck = Settings.PLAYER_HEALTH;


    /**
     * Settings variables, equal to the values in Settings
     * widthCheck must be equal to 750.0 as a double
     * heightCheck must be equal to 500.0 as a double
     * speedCheck must be equal to 3.0 as a double
     * healthCheck must be equal to 3 as an int
     * spawnCheck must be equal to 30 as a double
     */

    @Test
    void widthChecker() {
        assertEquals(750.0, widthCheck);
    }

    @Test
    void heightChecker() {
        assertEquals(500.0, heightCheck);
    }

    @Test
    void speedChecker() {
        assertEquals(3.0, speedCheck);
    }

    @Test
    void healthChecker() {
        assertEquals(3, healthCheck);
    }

}
/**
 * ScoreTest Class
 * Tests all the params in Score.java to see if all the methods work and values are initialized properly
 * Values must be at the right constants or tests will fail
 */
class ScoreTest {
    /**
     * Imitates the hostageCount variable in Score, and utilize the methods in hostageCount with it
     *
     * HostageCountCheck asserts that the hostageCount variable is initialized to zero
     * ScoreTestWorks asserts that the increaseScore() method works, and will increment 0 -> 1
     * EqualScoreTest asserts incrementing tempHostageCount manually is equal to increaseScore()
     * ScoreGoalTestWorks asserts that if we increment hostageCount to 4, which is >=4, the return value of goal() will be EQUAL to true
     */
    Score test = new Score();
    private int tempHostageCount= test.getHostageCount();

    @Test
    void HostageCountCheck() {
        assertEquals(0, tempHostageCount);
    }

    @Test
    public void ScoreTestWorks() {
        test.increaseScore();
        assertEquals(1,test.getHostageCount());
    }

    @Test
    public void EqualScoreTest() {
        tempHostageCount +=1;
        test.increaseScore();

        assertEquals(tempHostageCount, test.getHostageCount());
    }

    @Test
    public void ScoreGoalTestWorks() {
        for(int i = 0; i<5;i++){
            test.increaseScore();
        }
        boolean ScoreGoalTester = test.goal();
        assertEquals(ScoreGoalTester, true);
    }
}

/**
 * GoalTest Class
 * Tests all the params in Score.java to see if all the methods work and values are initialized properly
 * Values must be at the right constants or tests will fail
 */
class GoalTest {
    Goal tempGoal = new Goal();

    @Test
    @DisplayName("seeing the goal health")
    void goalHealth() {
        assertEquals(1, tempGoal.getHealth());
    }

    @Test
    @DisplayName("seeing the goal health after")
    void goalDamaged() {
        tempGoal.getDamaged();
        assertEquals(0, tempGoal.getHealth());
    }
}
