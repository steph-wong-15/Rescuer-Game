package com.group1;
import java.lang.*;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
/**
 * StartMenu
 * Executes the program functions
 */

public class StartMenu {
    public AnimationTimer gameLoop;
    Stage mainWindow;
    Scene gameScene;

    /**
     * Main game method where game loop runs
     * @param mouseEvent when player clicks play button
     */
    public void startButtonClick(MouseEvent mouseEvent) {
        ///////////////////////UI for main game screen//////////////////////
        //Outer layers
        BorderPane root = new BorderPane();
        StackPane group = new StackPane();
        gameScene = new Scene(root);

        // Inner layers
        Pane playfieldLayer = new Pane();
        playfieldLayer.setPrefSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        BackgroundSize backgroundSize= new BackgroundSize(Settings.SCENE_WIDTH,Settings.SCENE_HEIGHT,true,true,true,false);
        BackgroundImage backgroundImage= new BackgroundImage(Main.myImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        playfieldLayer.setBackground(new Background(backgroundImage));

        Pane scoreLayer = new Pane();
        scoreLayer.setPrefSize(Settings.SCENE_WIDTH, Settings.SCENE_HEIGHT);
        Button pauseButton =new Button("Pause");

        //stack layers together
        group.getChildren().addAll( playfieldLayer,scoreLayer);
        root.setCenter(group);
        root.setBottom(pauseButton);
        BorderPane.setAlignment(pauseButton,Pos.CENTER);
        //get stage from start menu to change scenes with same stage
        mainWindow = (Stage) (((Node) mouseEvent.getSource()).getScene().getWindow());
        mainWindow.setScene(gameScene);
        mainWindow.centerOnScreen();
        mainWindow.show();
        //////////////////////UI for main game screen////////////////////////

        //////////////////////Game loop/////////////////////////////////////
        Player thePlayer= Player.createPlayer(playfieldLayer);
        Score score = new Score(scoreLayer,thePlayer);
        Controller controller = new Controller(playfieldLayer,thePlayer,score);
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.tick();
                score.updateScore();
            }
        };
        gameLoop.start();
        //////////////////////Game loop/////////////////////////////////////

        //Check for pauseButton
        pauseButton.setOnAction(e->{
            try {
                settingButtonClicked();
                gameLoop.stop();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    /**
     * Setting window is created and game pauses.
     * Includes quit and resume options
     */
    public void settingButtonClicked() throws IOException {
        ///////////////////////UI for setting popup window///////////////////
        BorderPane borderPane = new BorderPane();
        HBox hbox = new HBox();
        hbox.setPrefSize(Settings.SCENE_WIDTH / 2, Settings.SCENE_HEIGHT / 2);
        Button quitButton = new Button("QUIT");
        hbox.setSpacing(10);
        Button resumeButton = new Button("RESUME");
        hbox.getChildren().addAll(quitButton, resumeButton);
        hbox.setAlignment(Pos.CENTER);
        borderPane.setCenter(hbox);
        Scene settingScene = new Scene(borderPane);
        Stage stage = new Stage();
        stage.setScene(settingScene);
        stage.centerOnScreen();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Settings");
        stage.show();
        ///////////////////////UI for setting popup window///////////////////

        //Check for quitButton and resumeButton
        resumeButton.setOnAction(e -> {
            stage.close();
            gameLoop.start();
        });
        quitButton.setOnAction(e -> {
            stage.close();
            mainWindow.close();
        });
    }
}
