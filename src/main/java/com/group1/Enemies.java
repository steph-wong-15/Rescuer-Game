package com.group1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Random;

/**
 * Enemy class
 * Extends off the Person class to generate enemy characters
 */
class Enemies extends Person{
    long last;

    /**
     * Enemy constructor
     * @param image Enemy Image
     * @param layer Layer that enemies is drawn on
     * @param x Starting location x
     * @param y Starting location y
     */
    public Enemies(Image image, Pane layer, double x, double y) {
        super(image, layer, x, y);
        health=1;
        damage=1;
        speed= 2;
    }

    /**
     * Enemies default constructor
     */
    Enemies(Pane pane){
        health=1;
        damage =1;
        speed =2;
        layer=pane;
        imageView=new ImageView(Main.hostageImage);
    }

    /**
     * Movement for enemy is horizontal and can randomly change every second from left to right
     */
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
    }

}