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
        if(running){
            super.start();
        }
    }

    @Override
    public void stop() {
        if(!running){
            super.stop();
        }
    }

    public abstract void tick(long now);
}

