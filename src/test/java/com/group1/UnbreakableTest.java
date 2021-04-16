package com.group1;

import javafx.scene.layout.Pane;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * SettingsTest Class
 * Tests all that walls are created and removed
 */
public class UnbreakableTest {
    Pane testPane = new Pane();
    Unbreakable tempUnbreakable = new Unbreakable(testPane);

    @Test
    public void addUnbreakableTest(){
        tempUnbreakable.addToLayer();
        assert(testPane.getChildren().contains(tempUnbreakable.imageView));
    }

    @Test
    public void removeUnbreakableTest(){
        tempUnbreakable.addToLayer();
        assert(testPane.getChildren().contains(tempUnbreakable.imageView));
        tempUnbreakable.removeFromLayer();
        assert(!testPane.getChildren().contains(tempUnbreakable.imageView));
    }
}
