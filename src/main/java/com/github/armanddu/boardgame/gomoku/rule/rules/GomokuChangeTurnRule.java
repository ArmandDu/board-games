package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.StoneRule;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

public class GomokuChangeTurnRule implements StoneRule {

  public String asString() {
    return "Change turn rule: Change turn after each stone move.";
  }

  public boolean isValid(BoardReader map, StoneMove move) {
    return true;
  }

}
