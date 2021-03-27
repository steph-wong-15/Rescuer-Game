package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

class Enemies extends Person{
    double playerMinX;
    double playerMaxX;
    double playerMinY;
    double playerMaxY;
    public Enemies(Image image, Pane layer, int health, int damage, double x, double y, double r, double dx, double dy, double dr) {
        super(image, layer, health, damage, x, y, r, dx, dy, dr);
         playerMinX = 0 - image.getWidth() / 2.0;
         playerMaxX = Settings.SCENE_WIDTH - image.getWidth() / 2.0;
         playerMinY = 0 - image.getHeight() / 2.0;
         playerMaxY = Settings.SCENE_HEIGHT -image.getHeight() / 2.0;

    }

    public boolean checkBounds(){
        // vertical
        if (Double.compare(y, playerMinY) < 0) {
            return true;
        } else if (Double.compare(y, playerMaxY) > 0) {
            return true;
        }
        // horizontal
        else if(Double.compare(x, playerMinX) < 0) {
            return true;
        } else if (Double.compare(x, playerMaxX) > 0) {
            return true;
        }
        return  false;
    }
}