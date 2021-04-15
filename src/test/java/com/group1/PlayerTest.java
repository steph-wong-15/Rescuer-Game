package com.group1;

import org.junit.jupiter.api.Test;
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
    Player tempPlayer = new Player();

    @Test
    public void playerHealthTest() {
        assertEquals(Settings.PLAYER_HEALTH, tempPlayer.getHealth());
    }
    @Test
    public void playerSpeedTest() {
        assertEquals(Settings.PLAYER_SPEED, tempPlayer.getSpeed());
    }

    @Test
    public void playerDamageTest(){
        assertEquals(1, tempPlayer.getDamageNum());
    }

}
