package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;


/**
 * Hostage Generator
 * Extends off the Person class to generate Hostages
 */

class Hostages extends Person{
    String name;

  public Hostages(Image image, Pane layer, double x, double y, String name) {
        super(image, layer, x, y);
        health=1;
        this.name = name;

  }
    public void move(){
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}