package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Unbreakable extends Person{


    public Unbreakable(Image image, Pane layer, double x, double y) {
        super(image, layer, x, y);
    }

    //walls are stationary
    public void move(){
    }
}

