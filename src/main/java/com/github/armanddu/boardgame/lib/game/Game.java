package com.github.armanddu.boardgame.lib.game;

public interface Game {

    void initGame();

    boolean isValid();

    boolean isStarted();

    boolean isEnded();

    void start();

    void reset();

}
