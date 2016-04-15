package com.github.armanddu.boardgames.lib.rule.config;

import com.github.armanddu.boardgames.go.game.GoGameManager;

public interface RuleConfig {

  void setStonePacks(GoGameManager manager);

  void setBoard(GoGameManager manager);

}
