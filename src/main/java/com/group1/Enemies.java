package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.Random;

class Enemies extends Person{
    long last;
    public Enemies(Image image, Pane layer, double x, double y) {
        super(image, layer, x, y);
        health=1;
        damage=1;
        speed= 2;
    }
    public void move(){
        if (System.currentTimeMillis() - last >= 1000) {
            Random rand = new Random();
            if(rand.nextInt(2)==0){
                dx=speed;
            }else{
                dx=-speed;
            }
            last = System.currentTimeMillis();
        }
        x += dx;
        y += dy;
        checkBounds();
    }

}