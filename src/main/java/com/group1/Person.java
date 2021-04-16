package com.group1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Person abstract Superclass
 * Gives attributes to Enemy, Goal, Hostage and Player subclasses
 */
public abstract class Person {
    Image image;
    ImageView imageView;
    Pane layer;
    double w; //width & height
    double h;
    double x; //location
    double y;
    double dx; //speed
    double dy;
    double speed;
    int damage;
    int health;

    /**
     * Person superclass constructor
     * @param image Image for character
     * @param layer Layer that character is drawn on
     * @param x Starting location x
     * @param y Starting location y
     */
    public Person(Image image, Pane layer, double x, double y) {
        this.image = image;
        this.layer = layer;
        this.x = x;
        this.y = y;
        this.imageView = new ImageView(image);
        this.imageView.relocate(x, y);
        this.w = image.getWidth(); // Get the Width & height of Image
        this.h = image.getHeight();
        addToLayer();
    }

    /**
     * Person default constructor
     */
    public Person(){}

    /**
     * default move function
     */
    public void move() {
        x += dx;
        y += dy;
    }

    /**
     * update and draw character position after applying movement
     */
    public void updateUI() {
        imageView.relocate(x, y);
    }

    /**
     * add character to its layer
     */
    public void addToLayer() { //Add Sprite to Layer
        this.layer.getChildren().add(this.imageView);
    }

    /**
     * remove character from its layer
     */
    public void removeFromLayer() { //Remove the Sprite from Layer
        this.layer.getChildren().remove(this.imageView);
    }

    /**
     * Getter for character health
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * Damaged applied to character upon collision
     */
    public void getDamaged() {
        health -= 1;
    }

    /**
     * Get x position
     * @return x position
     */
    public double getX(){
        return x;
    }

    /**
     * Get y position
     * @return y position
     */
    public double getY(){
        return y;
    }

    /**
     * Get speed as a double
     * @return speed
     */
    public double getSpeed(){return speed;}

    /**
     * Get damage as a double
     * @return damage
     */
    public int getDamageNum(){return damage;}

    /**
     * Set speed as a double
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Set speed as a double
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Check for collision with other characters
     * @param otherSprite other character
     * @return true if collided
     */
    public boolean CharacterCollision(Person otherSprite) {
        return (otherSprite.x + otherSprite.w >= x && otherSprite.y + otherSprite.h >= y && otherSprite.x <= x + w && otherSprite.y <= y + h);
    }

    /**
     * Keep character within playing boundaries
     */
    public void checkBounds() {
        //vertical
        if (y< 15) {
            y = 15;
        } else if (Double.compare(y, Settings.SCENE_HEIGHT - h-15) > 0) {
            y = Settings.SCENE_HEIGHT - h-15;
        }
        // horizontal
        if (x< 15) {
            x = 15;
        } else if (Double.compare(x, Settings.SCENE_WIDTH - w-15) > 0) {
            x = Settings.SCENE_WIDTH - w-15;
        }
    }
}
