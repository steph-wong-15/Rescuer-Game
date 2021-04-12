package com.group1;

import javafx.scene.image.Image;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Juniper Initial Class
 * Mere check to see if tests function properly
 */
class JUnitJupiterInitializeTest{
    int jupiter = 0;
    @Test
    void addition() {
        assertEquals(0, jupiter);
    }
}

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
