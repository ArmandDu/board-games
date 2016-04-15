package com.github.armanddu.boardgames.lib.rule;

import com.github.armanddu.boardgames.lib.game.GameManager;

public interface ConfigRule extends Rule{

  boolean isValid(GameManager manager);

  void set(GameManager manager);

}
