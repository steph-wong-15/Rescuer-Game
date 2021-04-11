package com.group1;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Where main game loop runs, characters and rewards live here
 */
public class Controller {
    Pane layer;
    Scene scene;
    Player thePlayer;
    boolean end;
    Score theScore;
    List<Person> objects = new ArrayList<>();
    int enemyCount;

    /**
     * Controls the moving parts of the game layer
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
        if (enemyCount < 10) {
            spawnEnemies();
        }
        //move, checkBounds & updateUI for all characters
        thePlayer.move();
        thePlayer.checkBounds();
        thePlayer.updateUI();
        for (Person character: objects ) {
            character.move();
            character.checkBounds();
            character.updateUI();
        }
        // check collisions
        checkCollisions();
        //end game
        playerDead();
        if(end){
            removeCharacters();
        }
        spawnGoal();
    }

    /**
     * Make hostages
     */
    private void spawnHostages() {
        // image
        Image image = Main.hostageImage;

        // create a sprite
        Hostages hostage = new Hostages(image, layer, 0, 0, "speed");
        Hostages hostage2 = new Hostages(image, layer, Settings.SCENE_WIDTH- image.getWidth(), 0, "health");
        Hostages hostage3 = new Hostages(image, layer, 0, Settings.SCENE_HEIGHT-image.getHeight(), "sword");
        Hostages hostage4 = new Hostages(image, layer,Settings.SCENE_WIDTH- image.getWidth(), Settings.SCENE_HEIGHT-image.getHeight(),"axe");
        // manage sprite
        objects.add(hostage);
        objects.add(hostage2);
        objects.add(hostage3);
        objects.add(hostage4);
    }

    /**
     * Make enemies
     */
    private void spawnEnemies() {
        Random rnd = new Random();
        Image image = Main.enemyImage;
        // make enemy is always fully inside the screen, no part of it is outside
        // y position: right on top of the view, so that it becomes visible with the next game iteration
        double x = rnd.nextDouble() * (Settings.SCENE_WIDTH-image.getWidth());
        double y = rnd.nextDouble() * (Settings.SCENE_HEIGHT-image.getHeight());
        //enemy cant spawn at players starting location
        if((x>thePlayer.x+2*image.getWidth()||x<thePlayer.x-2*image.getWidth())&&y>thePlayer.y+image.getHeight()||y<thePlayer.y-image.getHeight()){
            // create a sprite
            Enemies enemy = new Enemies(image, layer, x, y);

            // manage sprite
            objects.add(enemy);
            enemyCount++;
        }
    }

    /**
     * remove enemies when game is over
     */
    private void removeCharacters(){
        Iterator<Person> iterator = objects.listIterator();
        while (iterator.hasNext()) {
            Person tempPerson = iterator.next();
            if (tempPerson instanceof Enemies) {
                tempPerson.removeFromLayer();
                iterator.remove();
            }
            if (tempPerson instanceof Hostages) {
                tempPerson.removeFromLayer();
                iterator.remove();
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
                }
            } else if (tempPerson instanceof Enemies) {
                Enemies tempEnemy = (Enemies) tempPerson;
                if (thePlayer.CharacterCollision(tempEnemy)) { //if player hits enemy, true
                    tempEnemy.removeFromLayer();
                    iterator.remove();
                    thePlayer.getDamaged();
                    enemyCount--;
                }
            }
        }
    }

    /**
     * Check health and remove o health characters
     */
    private void playerDead() {
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





