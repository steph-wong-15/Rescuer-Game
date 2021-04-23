package com.group1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Trap extends Person{


    public Trap(Image image, Pane layer, double x, double y) {
        super(image, layer, x, y);
    }

    Trap(Pane pane){
        layer=pane;
        imageView=new ImageView(Main.wallImg);
    }

    //walls are stationary
    public void move(){
    }
}

