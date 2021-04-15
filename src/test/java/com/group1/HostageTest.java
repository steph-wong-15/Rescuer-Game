package com.group1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
