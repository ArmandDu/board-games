package com.github.armanddu.boardgames.lib.rule.config;

import com.github.armanddu.boardgames.gomoku.game.GomokuGameManager;

public interface RuleConfig {

  void setStonePacks(GomokuGameManager manager);

  void setBoard(GomokuGameManager manager);

}
