package com.group1;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

class Goal extends Person{
    /**
     * Goal Generator
     * Extends off the Person class to generate end state
     */
    private Goal(Image image, Pane layer, int health, int damage, double x, double y, double r, double dx, double dy, double dr) {
        super(image, layer, health, damage, x, y, r, dx, dy, dr);

    }

    /**
     * Makes bonus reward
     */
    public static Goal createGoal(Pane pane) {
        Image image = Main.greenImage;
        // center horizontally, position at 70% vertically
        double x = (Settings.SCENE_WIDTH - image.getWidth()) / 2.0;
        double y = Settings.SCENE_HEIGHT * 0.7;
        // create goal
        return new Goal(image, pane, 1, 0, x, y, 0, 0, 0, 0);
    }
}