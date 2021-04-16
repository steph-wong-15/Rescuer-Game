package com.group1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


/**
 * Hostage Generator
 * Extends off the Person class to generate Hostages
 */
class Hostages extends Person{
    String name;

    /**
     * Hostage constructor
     * @param image Hostage image
     * @param layer Layer that hostage is drawn on
     * @param x Starting location x
     * @param y Starting location x
     * @param name unique id
     */
      public Hostages(Image image, Pane layer, double x, double y, String name) {
            super(image, layer, x, y);
            health=1;
            this.name = name;
      }

    /**
     * Default constructor
     */
    Hostages(Pane pane){
        health=1;
        layer=pane;
        imageView=new ImageView(Main.hostageImage);
    }

    /**
     * hostage are held hostage so the cant move
     */
      public void move() {
      }
}