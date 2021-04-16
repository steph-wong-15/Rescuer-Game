package com.group1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Bonus reward
 * Extends off the Person class to generate bonus
 */
class Goal extends Person{
    private static Goal goal;
        /**
     * Goal Generator
     * Extends off the Person class to generate end state
     */
    private Goal(Image image, Pane layer, double x, double y) {
        super(image, layer, x, y);
        health = 1;
    }

    /**
     * Goal default constructor
     */
    Goal(Pane pane){
        health=1;
        layer=pane;
        imageView=new ImageView(Main.hostageImage);
    }

    /**
     * Makes bonus reward
     */
    public static Goal createGoal(Pane pane) {

    if (goal == null) {
        Image image = Main.greenImage;
        // center horizontally, position at 70% vertically
        double x = (Settings.SCENE_WIDTH - image.getWidth()) / 2.0;
        double y = Settings.SCENE_HEIGHT * 0.7;
        // create goal
        return new Goal(image, pane, x, y);
        }
    return goal;
    }

}