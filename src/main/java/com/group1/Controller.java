package com.group1;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Controller {
    Pane layer;
    Scene scene;
    Player thePlayer;
    Score theScore;
    List<Person> objects = new ArrayList<>();

    /**
     * Controls the moving parts of the game layer
     * @param pane get game layer where characters loaded
     * @param player the player
     * @param score communicates with game layer to display the score
     */
    Controller(Pane pane,Player player,Score score) {
        layer = pane;
        scene = pane.getScene();
        theScore=score;
        thePlayer=player;
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
    }

    /**
     * Make hostages
     */
    private void spawnHostages() {
        // image
        Image image = Main.hostageImage;

        // random speed
        double speed = 0;

        // make enemy is always fully inside the screen, no part of it is outside
        // y position: right on top of the view, so that it becomes visible with the next game iteration
        double x = 200;
        double y = 50;

        // create a sprite
        Hostages hostage = new Hostages(image, layer, 1, 1, x, 0, speed, 0, 1, 1, "speed");
        Hostages hostage2 = new Hostages(image, layer, 1, 1, x - 150, 0, speed, 0, 1, 1, "health");
        Hostages hostage3 = new Hostages(image, layer, 1, 1, x + 200, 0, speed, 0, 1, 1, "sword");
        Hostages hostage4 = new Hostages(image, layer, 1, 1, x + 300, 0, speed, 0, 1, 1, "axe");
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
        Enemies enemy = new Enemies(image, layer, 1, 1, x, 0, speed, 0, 1, 1);

        // manage sprite
        objects.add(enemy);
    }

    /**
     * Check for all types of collisions
     */
    private void checkCollisions() {
        Iterator<Person> iterator=objects.listIterator();
        while (iterator.hasNext()) {
            Person tempPerson=iterator.next();
            //System.out.println(i++);
//            for (Goal end : goals) {
//                if (player.CharacterCollision(end)) { //if player hits Goal, true
//                    collisionText.setText("You win!");
//                    goalState = true;
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException ex) {
//                        Thread.currentThread().interrupt();
//                    }
//                    end();
//                }
//            }
            if(tempPerson instanceof Hostages) {
                Hostages tempHostage = (Hostages) tempPerson;
                if (thePlayer.CharacterCollision(tempHostage)){//&& firstHostage == false && tempHostage.getName() == "speed") { //if player hits hostage, true
                    tempHostage.removeFromLayer();
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
            }
            else if(tempPerson instanceof Enemies){
                Enemies tempEnemy = (Enemies) tempPerson;
                if(tempEnemy.checkBounds()){
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

}




