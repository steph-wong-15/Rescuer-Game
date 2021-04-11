package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.util.Random;

class Enemies extends Person{
    public Enemies(Image image, Pane layer, double x, double y) {
        super(image, layer, x, y);
        health=1;
        damage=1;

    }
    public void move(){
        Random rand = new Random();
        if(rand.nextInt(2)==0){

        }else{

        }
    }
    public boolean checkBounds() {
        if (y< 0||Double.compare(y, Settings.SCENE_HEIGHT - h) > 0) {//vertical
            return true;
        } else if (x<0||Double.compare(x, Settings.SCENE_WIDTH - w) > 0) {//horizontal
            return true;
        }
        return false;
    }
}