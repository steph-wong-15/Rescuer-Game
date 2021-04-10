package com.group1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Iterator;

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
    double personMinX; //hitbox
    double personMaxX;
    double personMinY;
    double personMaxY;
    int damage;
    int health;

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
        setCharacterBounds();
    }

    public void move() {
        x += dx;
        y += dy;
    }

    public void updateUI() {
        imageView.relocate(x, y);
    }

    public void addToLayer() { //Add Sprite to Layer
        this.layer.getChildren().add(this.imageView);
    }

    public void removeFromLayer() { //Remove the Sprite from Layer
        this.layer.getChildren().remove(this.imageView);
    }

    public int getHealth() {
        return health;
    }

    public void getDamaged() {
        health -= 1;
    }

    /**
     * Hit box for player
     */
    private void setCharacterBounds() {
        personMinX = 0 - image.getWidth() / 2.0;
        personMaxX = Settings.SCENE_WIDTH - image.getWidth() / 2.0;
        personMinY = 0 - image.getHeight() / 2.0;
        personMaxY = Settings.SCENE_HEIGHT - image.getHeight() / 2.0;
    }

    public boolean CharacterCollision(Person otherSprite) {
        return (otherSprite.x + otherSprite.w >= x && otherSprite.y + otherSprite.h >= y && otherSprite.x <= x + w && otherSprite.y <= y + h);
    }

    public boolean checkBounds() {
        if (Double.compare(y, personMinY) < 0) {
            y = personMinY;
        } else if (Double.compare(y, personMaxY) > 0) {
            y = personMaxY;
        }
        // horizontal
        if (Double.compare(x, personMinX) < 0) {
            x = personMinX;
        } else if (Double.compare(x, personMaxX) > 0) {
            x = personMaxX;
        }
        return false;
    }

}