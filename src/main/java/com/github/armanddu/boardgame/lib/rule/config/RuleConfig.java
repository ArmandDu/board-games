package com.github.armanddu.boardgame.lib.rule.config;

import com.github.armanddu.boardgame.gomoku.board.GomokuGameManager;

public interface RuleConfig {

  void setStonePacks(GomokuGameManager manager);

  void setBoard(GomokuGameManager manager);

}
