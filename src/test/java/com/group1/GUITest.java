package com.group1;


import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.TextMatchers.hasText;


public class GUITest extends ApplicationTest {

    @Before
    public void setUp() throws Exception {
        ApplicationTest.launch(Main.class);
        clickOn("playButton");
    }

    @Override
    public void start(Stage stage){
        stage.show();
    }

    @After
    public void AfterTest() throws TimeoutException {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void StartMenuTest(){

    }

}
