package com.group1;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Iterator;

public abstract class Person{
    public int health;
    private int[][] pos;
    private int[][] size;

    Image image;
    ImageView imageView;
    Pane layer;

    double w; //width
    double h; //height

    double x; //x, y, r for diagonal
    double y;
    double r;

    double dx; //direction
    double dy;
    double dr;
    int damage;
    boolean canMove = true;
    boolean removable = false;
    public Person(Image image, Pane layer, int health, int damage, double x, double y, double r, double dx, double dy, double dr) {

        this.image = image;
        this.layer = layer;
        this.health = health;
        this.damage = damage;


        this.x = x;
        this.y = y;
        this.r = r;
        this.dx = dx;
        this.dy = dy;
        this.dr = dr;

        this.imageView = new ImageView(image);
        this.imageView.relocate(x, y);
        this.imageView.setRotate(r);

        this.w = image.getWidth(); // Get the Width of Image
        this.h = image.getHeight(); // imageView.getBoundsInParent().getHeight();

        addToLayer();
    }

    public static Iterator<? extends Person> iterator() {
        return iterator();
    }

    public void addToLayer() { //Add Sprite to Layer
        this.layer.getChildren().add(this.imageView);
    }

    public void removeFromLayer() { //Remove the Sprite from Layer
        this.layer.getChildren().remove(this.imageView);
    }

    public Pane getLayer() { //get the Layer
        return layer;
    }

    public void setLayer(Pane layer) { //set the Layer
        this.layer = layer;
    }

    //return the damage
    public double getDamage() {
        return damage;
    }

    //return the health
    public int getHealth() {
        return health;
    }

    //set the damageDone
    public void setHealth(int newHealth){
        this.health = newHealth;
    }

    public void move(){
        if( !canMove) //if moveable, return
            return;

        x += dx;
        y += dy;
        r += dr;
    }

    public void wallCollision(Wall w){
        //implement wallCollision
    }



    public void draw(){
        //implement a drawing function
    }
    //extra setters and getters
    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getDr() {
        return dr;
    }

    public void setDr(double dr) {
        this.dr = dr;
    }
    //kill player
    public void kill() {
        setHealth(0);
    }

    public boolean isAlive() { //returns the difference of health
        return Double.compare(health, 0) > 0;
    }

    public ImageView getView() { //get the view
        return imageView;
    }
    public void updateUI() {

        imageView.relocate(x, y);
        imageView.setRotate(r);

    }
    public double getWidth() {
        return w;
    }

    public double getHeight() {
        return h;
    }

    public double getCenterX() { //get the centre x coordinate
        return x + w * 0.5;
    }

    public double getCenterY() { //get the centre y coordinate
        return y + h * 0.5;
    }

    public boolean isRemovable() { //getter for removable
        return removable;
    }
    public void remove() { //CHANGE TO REMOVABLE OBJECT
        setRemovable(true);
    }
    public void setRemovable(boolean removable) {
        this.removable = removable;
    }
    public void stopMovement() { //prevent movement
        this.canMove = false;
    }

    public void checkRemovability() {
        //default
    }
    public void getDamaged( Person sprite) {
        health -= sprite.getDamage();
    }
    public boolean CharacterCollision( Person otherSprite) {

        return ( otherSprite.x + otherSprite.w >= x && otherSprite.y + otherSprite.h >= y && otherSprite.x <= x + w && otherSprite.y <= y + h);

    }
}