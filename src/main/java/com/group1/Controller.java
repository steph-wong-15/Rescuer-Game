package com.group1;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Controller {
    Pane layer;
    Scene scene;
    Player thePlayer;
    boolean end;
    Score theScore;
    List<Person> objects = new ArrayList<>();

    /**
     * Controls the moving parts of the game layer
     *
     * @param pane   get game layer where characters loaded
     * @param player the player
     * @param score  communicates with game layer to display the score
     */
    Controller(Pane pane, Player player, Score score) {
        layer = pane;
        scene = pane.getScene();
        theScore = score;
        thePlayer = player;
        spawnHostages();
    }

    /**
     * Where all the necessary components are called to run
     * and update game while playing
     */
    public void tick() {
        thePlayer.processInput();
        spawnEnemies(true);
        //move
        thePlayer.move();
        objects.forEach(sprite -> sprite.move());
        // check collisions
        checkCollisions();
        // update sprites in scene
        thePlayer.updateUI();
        objects.forEach(sprite -> sprite.updateUI());
        removeDead();
        spawnGoal();
    }

    /**
     * Make hostages
     */
    private void spawnHostages() {
        // image
        Image image = Main.hostageImage;

        // make enemy is always fully inside the screen, no part of it is outside
        // y position: right on top of the view, so that it becomes visible with the next game iteration
        double x = 200;
        double y = 50;

        // create a sprite
        Hostages hostage = new Hostages(image, layer, x, 0, "speed");
        Hostages hostage2 = new Hostages(image, layer, x - 150, 0, "health");
        Hostages hostage3 = new Hostages(image, layer, + 200, 0, "sword");
        Hostages hostage4 = new Hostages(image, layer,x + 300, 0,"axe");
        // manage sprite
        objects.add(hostage);
        objects.add(hostage2);
        objects.add(hostage3);
        objects.add(hostage4);
    }

    /**
     * Make enemies
     * @param random random
     */
    private void spawnEnemies(boolean random) {
        if (!end) {
            Random rnd = new Random();
            if (random && rnd.nextInt(Settings.ENEMY_SPAWN_RANDOMNESS) != 0) {
                return;
            }
            // image
            Image image = Main.enemyImage;

            // random speed
            double speed = rnd.nextDouble() * 1.0 + 2.0;

            // make enemy is always fully inside the screen, no part of it is outside
            // y position: right on top of the view, so that it becomes visible with the next game iteration
            double x = rnd.nextDouble() * (Settings.SCENE_WIDTH - image.getWidth());
            double y = -image.getHeight();

            // create a sprite
            Enemies enemy = new Enemies(image, layer, x, 0);

            // manage sprite
            objects.add(enemy);
        } else {
            Iterator<Person> iterator = objects.listIterator();
            while (iterator.hasNext()) {
                Person tempPerson = iterator.next();
                if (tempPerson instanceof Enemies) {
                    tempPerson.removeFromLayer();
                    iterator.remove();
                }
            }
        }
    }

    /**
     * Create Bonus reward
     */
    private void spawnGoal() {
        if (theScore.goal()) {
            objects.add(Goal.createGoal(layer));
        }
    }

    /**
     * Check for all types of collisions
     */
    private void checkCollisions() {
        Iterator<Person> iterator = objects.listIterator();
        while (iterator.hasNext()) {
            Person tempPerson = iterator.next();
            if (tempPerson instanceof Goal) {
                if (thePlayer.CharacterCollision(tempPerson)) {
                    end = true;
                    tempPerson.removeFromLayer();
                    iterator.remove();
                    end();
                }
            }
            if (tempPerson instanceof Hostages) {
                if (thePlayer.CharacterCollision(tempPerson)) {//&& firstHostage == false && tempHostage.getName() == "speed") { //if player hits hostage, true
                    tempPerson.removeFromLayer();
                    iterator.remove();
                    theScore.increaseScore();
//                } else if (thePlayer.CharacterCollision(tempHostage)){// && secondHostage == false && tempHostage.getName() == "sword") { //if player hits hostage, true
//                    //objects.remove(object);
//                    theScore.increaseScore();
//                } else if (thePlayer.CharacterCollision(tempHostage)){//&& thirdHostage == false && tempHostage.getName() == "axe") { //if player hits hostage, true
//                    //objects.remove(object);
//                    theScore.increaseScore();
//                } else if (thePlayer.CharacterCollision(tempHostage)){// && fourthHostage == false && tempHostage.getName() == "health") { //if player hits hostage, true
//                    //objects.remove(object);
//                    theScore.increaseScore();
                }
            } else if (tempPerson instanceof Enemies) {
                Enemies tempEnemy = (Enemies) tempPerson;
                if (tempEnemy.checkBounds()) {
                    tempEnemy.removeFromLayer();
                    iterator.remove();
                }
                if (thePlayer.CharacterCollision(tempEnemy)) { //if player hits enemy, true
                    tempEnemy.removeFromLayer();
                    iterator.remove();
                    thePlayer.getDamaged();
                }
            }
        }
    }

    /**
     * Check health and remove o health characters
     */
    private void removeDead() {
        if (thePlayer.getHealth() < 1) {
            thePlayer.removeFromLayer();
            end = true;
            loss();
        }
    }

    /**
     * Ending background when player wins
     */
    private void end() {
        BackgroundSize backgroundSize = new BackgroundSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(Main.winnerImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        layer.setBackground(new Background(backgroundImage));
    }

    /**
     * Ending background when player loses
     */
    public void loss() { //ending screen
        BackgroundSize backgroundSize = new BackgroundSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(Main.loserImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        layer.setBackground(new Background(backgroundImage));
    }
}





