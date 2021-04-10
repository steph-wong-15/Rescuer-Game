package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

class Enemies extends Person{
    public Enemies(Image image, Pane layer, double x, double y) {
        super(image, layer, x, y);
        health=1;
        damage=1;

    }
    public void move(){

    }
}