package com.github.armanddu.boardgame.lib.game;

public interface Game {

  boolean isValid();

  boolean isStarted();

  boolean isEnded();

  void start();

  void reset();

}
