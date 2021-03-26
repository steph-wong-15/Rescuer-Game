package com.group1;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {
    Pane layer;
    Scene scene;
    Player thePlayer;
    Score theScore;
    List<Person> objects = new ArrayList<>();
    List<Goal> goals = new ArrayList<>();
    boolean firstHostage = false; //1st hostage checker
    boolean secondHostage = false; //2nd hostage checker
    boolean thirdHostage = false; //3rd hostage checker
    boolean fourthHostage = false; //4th hostage checker
    boolean collision = false; //check collision with enemy
    boolean hostageCollision = false; //hostage collision


    Controller(Pane pane,Player player,Score score) {
        layer = pane;
        scene = pane.getScene();
        theScore=score;
        thePlayer=player;
        spawnHostages();
    }

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
        // check if sprite can be removed
        //enemies.forEach(sprite -> sprite.checkRemovability());
        // update score, health, etc
        //updateScore();
    }

//    /**
//     * Make player
//     */
//    private void createPlayer() {
//        //image
//        Image image = Main.playerImage;
//        // player input
//        Input input = new Input(scene); //use temporary scene var
//
//        // register input listeners
//        input.addListeners();
//
//        // center horizontally, position at 70% vertically
//        double x = (Settings.SCENE_WIDTH - image.getWidth()) / 2.0;
//        double y = Settings.SCENE_HEIGHT * 0.7;
//
//        // create player
//        player = new Player(image, layer, Settings.PLAYER_HEALTH, 0, x, y, 0, 0, 0, 0, Settings.PLAYER_SPEED, input);
//    }

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
     *
     * @param random
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
    private void checkCollisions() {
        collision = false;
        hostageCollision = false;
        for (Person object : objects) {
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
//
//                }
//            }
            if(object instanceof Hostages) {
                Hostages tempHostage = (Hostages) object;
                if (thePlayer.CharacterCollision(tempHostage)){//&& firstHostage == false && tempHostage.getName() == "speed") { //if player hits hostage, true
                    //hostageCollision = true;
                    //firstHostage = true;
                    //hostageCount++;
                    //updateScore();
                    //objects.remove(object);
                    theScore.increaseScore();
                } else if (thePlayer.CharacterCollision(tempHostage)){// && secondHostage == false && tempHostage.getName() == "sword") { //if player hits hostage, true
//                    hostageCollision = true;
//                    secondHostage = true;
                    //hostageCount++;
                    //updateScore();
                    //objects.remove(object);
                    theScore.increaseScore();
                } else if (thePlayer.CharacterCollision(tempHostage)){//&& thirdHostage == false && tempHostage.getName() == "axe") { //if player hits hostage, true
//                    hostageCollision = true;
//                    thirdHostage = true;
                    //hostageCount++;
                    //updateScore();
                    //objects.remove(object);
                    theScore.increaseScore();
                } else if (thePlayer.CharacterCollision(tempHostage)){// && fourthHostage == false && tempHostage.getName() == "health") { //if player hits hostage, true
//                    hostageCollision = true;
//                    fourthHostage = true;
                    //hostageCount++;
                    //updateScore();
                    //objects.remove(object);
                    theScore.increaseScore();
                }
            }
            else if(object instanceof Enemies){
                Enemies tempEnemy = (Enemies) object;
                if (thePlayer.CharacterCollision(tempEnemy)) { //if player hits enemy, true
                    //collision = true;
                    System.out.println("ENEMy");
                }
            }
        }
    }

}




