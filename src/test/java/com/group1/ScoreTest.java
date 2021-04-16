package com.group1;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import org.junit.After;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ScoreTest Class
 * Tests all the params in Score.java to see if all the methods work and values are initialized properly
 * Values must be at the right constants or tests will fail
 */
public class ScoreTest {
    /**
     * Imitates the hostageCount variable in Score, and utilize the methods in hostageCount with it
     * HostageCountCheck asserts that the hostageCount variable is initialized to zero
     * ScoreTestWorks asserts that the increaseScore() method works, and will increment 0 -> 1
     * EqualScoreTest asserts incrementing tempHostageCount manually is equal to increaseScore()
     * ScoreGoalTestWorks asserts that if we increment hostageCount to a value >=4, the return value of goal() will be EQUAL to true
     * EndVarFalse asserts that the End bool variable in Score is false. This is important, as if end var isn't initialized as false then the game will skip ahead
     * WinVarFalse asserts that the Win bool variable in Score is false. This is important, as if win var isn't initialized as false, the game will skip ahead
     */

    Score test = new Score();
    private int tempHostageCount= test.getHostageCount();

    @After
    public void clean(){
        test=new Score();
    }

    @Test
    public void HostageCountTest() {
        assertEquals(0, tempHostageCount);
    }

    @Test
    public void IncreaseHostageTest() {
        int tempHostageCount=test.getHostageCount();
        test.increaseScore();
        assertEquals(tempHostageCount+1,test.getHostageCount());
    }

    @Test
    public void ScoreGoalTestWorks() {
        assertFalse(test.goal());
        for(int i = 0; i<5;i++){
            test.increaseScore();
        }
        assertTrue(test.goal());
    }

    @Test
    public void EndVarFalse(){
        assertFalse(test.getEnd());
    }

    @Test
    public void WinVarFalse(){
        assertFalse(test.getWin());
    }

    @Test
    public void BonusTest(){
        assertFalse(test.bonus);
        test.bonusCollected();
        assertTrue(test.bonus);
    }

    @Test
    public void testWin(){
        test.win();
        assert(test.getWin());
        assert(test.getEnd());
    }

    @Test
    public void winBonusTest(){
        int timeUsedRnd= new Random().nextInt(301);
        test.setTimeUsed(timeUsedRnd);
        test.setWin(true);
        test.setEnd(true);
        test.bonusCollected();
        test.calculateScore();
        assert(test.getEndScore() >=5000);
        assert(test.getEndScore() <=Settings.TIME_LIMIT*10+5000);
    }

    @Test
    public void winNoBonus(){
        int timeUsedRnd= new Random().nextInt(301);
        test.setTimeUsed(timeUsedRnd);
        test.setWin(true);
        test.setEnd(true);
        test.calculateScore();
        assert(test.getEndScore() >=4000);
        assert(test.getEndScore() <=Settings.TIME_LIMIT*10+4000);
    }

    @Test
    public void LoseBonus(){
        int timeUsedRnd= new Random().nextInt(301);
        test.setTimeUsed(timeUsedRnd);
        test.setWin(false);
        test.setEnd(true);
        test.bonusCollected();
        test.calculateScore();
        assert(test.getEndScore() >=0);
        assert(test.getEndScore() <=Settings.TIME_LIMIT*99);
    }

    @Test
    public void LoseNoBonus(){
        int timeUsedRnd= new Random().nextInt(301);
        test.setTimeUsed(timeUsedRnd);
        test.setWin(false);
        test.setEnd(true);
        test.calculateScore();
        assert(test.getEndScore() >=0);
        assert(test.getEndScore() <=Settings.TIME_LIMIT*4); //Max of 4 hostages
    }
}

