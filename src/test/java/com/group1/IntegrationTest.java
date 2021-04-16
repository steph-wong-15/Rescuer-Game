package com.group1;


import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * IntegrationTest Class
 * Tests the RELEVANT integrations throughout the project to see if all the objects work and values are initialized properly
 * Objects must be properly declared or tests will fail
 * Handles CROSS-CLASS INTERACTIONS
 */
public class IntegrationTest{
    Pane testPane = new Pane();
    Player integrationPlayer = new Player(testPane);
    Enemies integrationEnemies = new Enemies(testPane);
    Hostages integrationHostages = new Hostages(testPane);

    Controller tempController = new Controller();
    Input inputTest = new Input();

    /**
     * playerEnemyEquals asserts that if the default health of the player (3) is equal
     * to three damaging hits by an enemy, and asserts the player would have 0 health on three hits
     */
    @Test
    public void playerEnemyEquals(){
        assertEquals(integrationPlayer.getHealth(), integrationEnemies.getDamageNum()*3);
        for (int i =0; i<integrationEnemies.getDamageNum()*3;i++){
            integrationPlayer.getDamaged(); //let player get damaged 3 times
        }
        assertEquals(integrationPlayer.getHealth(), 0);
    }


    /**
     * CorrectClassInputs checks if the Initialization of move up/down/right/left works perfectly, should default to False for all four, else inputs may be incorrectly initialized
     */
    @Test
    public void CorrectClassInputs(){

        boolean moveUp= inputTest.isMoveUp();
        boolean moveDown= inputTest.isMoveDown();
        boolean moveRight= inputTest.isMoveRight();
        boolean moveLeft= inputTest.isMoveLeft();
        assertFalse(moveUp);
        assertFalse(moveDown);
        assertFalse(moveRight);
        assertFalse(moveLeft);
    }

    @Test
    /**
     * Compares the methods in controller, tests if variables can work across to Person class and subclasses
     * Tests if variables added to Controller initialize properly
     * Asserts EnemyCount is initialized to zero
     * Asserts objects arraylist to a newly created ArrayList of the same format - checks that it's initialized as Null as well
     * Checks if objects can properly add Player/Enemy/Hostage (subclasses of Person class) to the object arraylist, asserts size() correctly
     */
    public void ControllerCrossClass(){
        assertEquals(0,tempController.enemyCount);

        List<Person> tempPersonArray = new ArrayList<>();
        assertEquals(tempPersonArray,tempController.objects);

        tempController.objects.add(tempController.thePlayer);
        tempController.objects.add(integrationPlayer);
        tempController.objects.add(integrationEnemies);
        tempController.objects.add(integrationHostages);
        assertEquals(tempController.objects.size(), 4);
    }

    /**
     * Test that Asserts the functionality of the Person.CharacterCollision with Enemies, proves cross functionality. Should return true.
     */
    @Test

    public void CharacterCollision(){
        boolean test = integrationPlayer.CharacterCollision(integrationEnemies);
        assertTrue(test);
    }



}
