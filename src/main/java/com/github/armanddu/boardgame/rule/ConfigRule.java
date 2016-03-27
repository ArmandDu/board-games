package com.github.armanddu.boardgame.rule;

import com.github.armanddu.boardgame.game.GameManager;

public interface ConfigRule extends Rule{

  boolean isValid(GameManager manager);

  void set(GameManager manager);

}
