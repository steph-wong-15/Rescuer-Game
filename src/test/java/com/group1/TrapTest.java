package com.group1;

import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * SettingsTest Class
 * Tests all that walls are created and removed
 */
public class TrapTest {
    Pane testPane = new Pane();
    Trap tempTrap = new Trap(testPane);

    @Test
    public void addUnbreakableTest(){
        tempTrap.addToLayer();
        assert(testPane.getChildren().contains(tempTrap.imageView));
    }

    @Test
    public void removeUnbreakableTest(){
        tempTrap.addToLayer();
        assert(testPane.getChildren().contains(tempTrap.imageView));
        tempTrap.removeFromLayer();
        assert(!testPane.getChildren().contains(tempTrap.imageView));
    }
}
