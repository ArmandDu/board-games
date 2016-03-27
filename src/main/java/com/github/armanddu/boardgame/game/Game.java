package com.github.armanddu.boardgame.game;

public interface Game {

  boolean isValidRequirements();

  boolean isStarted();

  boolean isEnded();

  void start();

  void reset();

}
