package com.github.armanddu.boardgame.lib.rule;

import com.github.armanddu.boardgame.lib.rule.config.RuleConfig;
import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

public interface GameRules {

  void configGame(GameManager config);

  RuleConfig getConfig();

  boolean isValidGame(GameManager config);

  boolean isValidMove(BoardReader map, StoneMove move);

  boolean hasCaptures(BoardReader map, StoneMove move);

  boolean shouldChangeTurn(BoardReader map, StoneMove move);

  boolean isEndGame(BoardReader map, StoneMove move);

  boolean isWin(BoardReader map, StoneMove move);

  boolean isDraw(BoardReader map, StoneMove move);

  Rule getLastInvalidRule();

}
