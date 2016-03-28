package com.github.armanddu.boardgame.rule;

import com.github.armanddu.boardgame.rule.config.RuleConfig;
import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.stone.StoneMove;

public interface GameRules {

  void configGame(GameManager config);

  RuleConfig getConfig();

  boolean isValidGame(GameManager config);

  boolean isValidMove(BoardReader map, StoneMove stoneMove);

  boolean hasCaptures(BoardReader map, StoneMove stoneMove);

  boolean shouldChangeTurn(BoardReader map, StoneMove stoneMove);

  boolean isEndGame(BoardReader map, StoneMove stoneMove);

  boolean isWin(BoardReader map, StoneMove stoneMove);

  boolean isDraw(BoardReader map, StoneMove stoneMove);

  Rule getLastInvalidRule();

}
