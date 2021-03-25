package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

class Goal extends Person{
    /**
     * Goal Generator
     * Extends off the Person class to generate end state
     */

    public Goal(Image image, Pane layer, int health, int damage, double x, double y, double r, double dx, double dy, double dr) {
        super(image, layer, health, damage, x, y, r, dx, dy, dr);

    }


    public void checkRemovability() {
        //default
        if( Double.compare( getY(), Settings.SCENE_HEIGHT) > 0) {
            setRemovable(true);
        }
    }
}