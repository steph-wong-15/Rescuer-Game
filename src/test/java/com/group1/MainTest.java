package com.group1;


import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.util.concurrent.TimeoutException;


public class MainTest extends ApplicationTest {

    @Before
    public void setUp() throws Exception {
    ApplicationTest.launch(Main.class);
    }

    @Override
    public void start(Stage stage){
        stage.show();
    }

    @After
    public void startingScreen() throws TimeoutException {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }


}
