package com.group1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ScoreTest Class
 * Tests all the params in Score.java to see if all the methods work and values are initialized properly
 * Values must be at the right constants or tests will fail
 */
public class ScoreTest {
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
    public void HostageCountCheck() {
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
        assertTrue(ScoreGoalTester);
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

