package com.github.armanddu.boardgame.lib.rule;

import com.github.armanddu.boardgame.lib.game.GameManager;

public interface ConfigRule extends Rule{

  boolean isValid(GameManager manager);

  void set(GameManager manager);

}