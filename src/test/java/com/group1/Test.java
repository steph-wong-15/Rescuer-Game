package com.group1;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * SettingsTest Class
 * Tests all the params in Settings.java to see if they are the right values
 * Values must be at the right constants or tests will fail
 */
class SettingsTest{

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
     * ScoreGoalTestWorks asserts that if we increment hostageCount to a value >=4, the return value of goal() will be EQUAL to true
     * EndVarFalse asserts that the End bool variable in Score is false. This is important, as if end var isn't initialized as false then the game will skip ahead
     * WinVarFalse asserts that the Win bool variable in Score is false. This is important, as if win var isn't initialized as false, the game will skip ahead
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

    @Test
    public void EndVarFalse(){
        boolean tempEnd = test.getEnd();
        assertFalse(tempEnd);
    }

    @Test
    public void WinVarFalse(){
        boolean tempWin = test.getWin();
        assertFalse(tempWin);
    }

}

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
/**
 * HostageTest Class
 * Tests all the params in Hostages.java to see if all the methods work and values are initialized properly
 * Values must be at the right constants or tests will fail
 */
class HostageTest {

/**
 * hostageHealth asserts that getHealth returns the proper goal value of 1 - which is true!)
 */
Hostages tempHostages = new Hostages();

    @Test
    void hostageHealthTest() {
        assertEquals(1, tempHostages.getHealth());
    }
    @Test
    void hostageDamagedHealthTest() {
        tempHostages.getDamaged(); //-1 health
        assertEquals(0, tempHostages.getHealth());
    }


}

/**
 * PlayerTest Class
 * Tests all the params in Player.java to see if all the methods work and values are initialized properly
 * Values must be at the right constants (Settings values!) or tests will fail
 */

class PlayerTest {

    /**
     * PlayerHealth asserts that getHealth returns the proper goal value of PLAYER_HEALTH, a settings value - which is true!
     * PlayerSpeed asserts that getSpeed returns the proper goal value of PLAYER_SPEED, a settings value - which is true!)
     * PlayerDamage asserts that getDamage returns the proper goal value of 1, which is true!)
     */
    Player tempPlayer = new Player();

    @Test
    void playerHealthTest() {
        assertEquals(Settings.PLAYER_HEALTH, tempPlayer.getHealth());
    }
    @Test
    void playerSpeedTest() {
        assertEquals(Settings.PLAYER_SPEED, tempPlayer.getSpeed());
    }

    @Test
    void playerDamageTest(){
        assertEquals(1, tempPlayer.getDamageNum());
    }

}
/**
 * EnemiesTest Class
 * Tests all the params in Enemies.java to see if all the methods work and values are initialized properly
 * Values must be at the right constants or tests will fail
 */

class EnemiesTest {

    /**
     * EnemiesHealth asserts that getHealth returns the proper goal value of 1, which is true!
     * EnemiesSpeed asserts that getSpeed returns the proper goal value of 2, which is true!
     * EnemiesDamage asserts that getDamage returns the proper goal value of 1, which is true!
     */
    Enemies tempEnemies = new Enemies();

    @Test
    void enemiesHealthTest() {
        assertEquals(1, tempEnemies.getHealth());
    }
    @Test
    void enemiesSpeedTest() {
        assertEquals(2, tempEnemies.getSpeed());
    }

    @Test
    void enemiesDamageTest(){
        assertEquals(1, tempEnemies.getDamageNum());
    }

}



