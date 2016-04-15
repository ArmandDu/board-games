package com.github.armanddu.boardgames.lib.rule;

import com.github.armanddu.boardgames.lib.rule.config.RuleConfig;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

public interface GameRules {

  void configGame(GameManager game);

  RuleConfig getConfig();

  boolean isValidGame(GameManager config);

  boolean isValidMove(BoardReader map, StoneMove move);

  boolean shouldChangeTurn(BoardReader map, StoneMove move);

  boolean isEndGame(BoardReader map, StoneMove move);

  boolean isWin(BoardReader map, StoneMove move);

  boolean isDraw(BoardReader map, StoneMove move);

  Rule getLastInvalidRule();

}
