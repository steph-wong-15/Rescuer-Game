package com.group1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Random;

/**
 * Bonus reward Class
 * Extends off the Person class to generate the Bonus
 * Singleton
 */
public class Bonus extends Person{
    private static Bonus bonus;
    String name;

    /**
     * Bonus constructor
     * @param image Hostage image
     * @param layer Layer that bonus is drawn on
     * @param x     Starting location x
     * @param y     Starting location x
     * @param name  unique id
     */
    private Bonus(Image image, Pane layer, double x, double y, String name) {
        super(image, layer, x, y);
        this.name=name;
    }

    /**
     * Default constructor
     */
    Bonus(Pane pane){
        health=1;
        layer=pane;
        imageView=new ImageView(Main.bonus);
    }

    /**
     * Create bonus reward instance
     * @param layer Layer that bonus is drawn on
     * @return instance of bonus
     */
    public static Bonus createBonus(Pane layer){
        Random r= new Random();
        double xPos =(Settings.SCENE_WIDTH-Main.bonus.getWidth())*r.nextDouble();
        double yPos= (Settings.SCENE_HEIGHT-Main.bonus.getHeight())*r.nextDouble();
        if(bonus==null){
            return new Bonus(Main.bonus,layer,xPos, yPos,"bonus");
        }
        return bonus;
    }
}
