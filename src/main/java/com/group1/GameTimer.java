package com.group1;

import javafx.animation.AnimationTimer;

public abstract class GameTimer extends AnimationTimer {

    boolean running;
    @Override
    public void handle(long l) {
        tick(l);
    }

    @Override
    public void start() {
        super.start();
        running =true;
    }

    @Override
    public void stop() {
        super.stop();
        running =false;
    }

    public abstract void tick(long now);
}

