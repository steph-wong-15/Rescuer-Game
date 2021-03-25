package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


/**
 * Hostage Generator
 * Extends off the Person class to generate Hostages
 */

class Hostages extends Person{

    String name;
  public Hostages(Image image, Pane layer, int health, int damage, double x, double y, double r, double dx, double dy, double dr, String name) {
        super(image, layer, health, damage, x, y, r, dx, dy, dr);
        this.name = name;

  }
    public void checkRemovability() {
        //default
        if( Double.compare( getY(), Settings.SCENE_HEIGHT) > 0) {
            setRemovable(true);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}