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
    Score theScore;
    List<Person> objects = new ArrayList<>();
    List<Unbreakable> walls = new ArrayList<>();
    int enemyCount;
    int border=15;

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

        createWalls();

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
        checkPlayerCollisions();
        //end game
        playerDead();
        if(theScore.end){
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
        Hostages hostage = new Hostages(image, layer, border, border, "speed");
        Hostages hostage2 = new Hostages(image, layer, Settings.SCENE_WIDTH- image.getWidth()-border, border, "health");
        Hostages hostage3 = new Hostages(image, layer, border, Settings.SCENE_HEIGHT-image.getHeight(), "sword");
        Hostages hostage4 = new Hostages(image, layer,Settings.SCENE_WIDTH- image.getWidth()-border, Settings.SCENE_HEIGHT-image.getHeight(),"axe");

        // add sprite
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
        if((x>thePlayer.x+image.getWidth()||x<thePlayer.x-image.getWidth())&&y>thePlayer.y+image.getHeight()||y<thePlayer.y-image.getHeight()){
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
            if(tempPerson instanceof Goal){
                tempPerson.removeFromLayer();
                iterator.remove();
            }
            if(tempPerson instanceof Bonus){
                tempPerson.removeFromLayer();
                iterator.remove();
            }
            if(tempPerson instanceof Unbreakable){
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
            objects.add(Bonus.createBonus(layer));
        }
    }

    /**
     * Check for all types of collisions
     */
    private void checkPlayerCollisions() {
        Iterator<Person> iterator = objects.listIterator();
        while (iterator.hasNext()) {
            Person tempPerson = iterator.next();
            if (tempPerson instanceof Goal) {
                if (thePlayer.CharacterCollision(tempPerson)) {
                    theScore.win();
                    tempPerson.removeFromLayer();
                    iterator.remove();
                    end();
                }
            }
            if (tempPerson instanceof Bonus) {
                if (thePlayer.CharacterCollision(tempPerson)) {
                    tempPerson.removeFromLayer();
                    iterator.remove();
                    theScore.bonusCollected();
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
            if (tempPerson instanceof Unbreakable){
                if (thePlayer.CharacterCollision(tempPerson)) {
                    thePlayer.x = (Settings.SCENE_WIDTH - thePlayer.image.getWidth()) / 2.0;
                    thePlayer.y = Settings.SCENE_HEIGHT * 0.7;
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
            theScore.end = true;
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
    public void loss() {
        BackgroundSize backgroundSize = new BackgroundSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(Main.loserImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        layer.setBackground(new Background(backgroundImage));
    }

    /**
     * Creates the unbreakable walls
     */

    private void createWalls() {
        // image
        Image image = Main.wallImg;
        Image image1 = Main.wallImgA;
        Image image2 = Main.wallImgB;

        // create an unbreakable walls
        Unbreakable wall1 = new Unbreakable(image, layer, 400, 405);
        Unbreakable wall2 = new Unbreakable(image, layer, 100, 305);
        Unbreakable wall3 = new Unbreakable(image, layer, 450, 205);
        Unbreakable wall4 = new Unbreakable(image, layer, 300, 15);
        Unbreakable wall5 = new Unbreakable(image1, layer, 0, 0);
        Unbreakable wall6 = new Unbreakable(image1, layer, Settings.SCENE_WIDTH-border, 0);
        Unbreakable wall7 = new Unbreakable(image2, layer, 0, 0);
        Unbreakable wall8 = new Unbreakable(image2, layer, 0, Settings.SCENE_HEIGHT-border);

        objects.add(wall1);
        objects.add(wall2);
        objects.add(wall3);
        objects.add(wall4);

    }
}





