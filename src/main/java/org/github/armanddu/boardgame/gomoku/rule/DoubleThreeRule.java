package org.github.armanddu.boardgame.gomoku.rule;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.rule.Rule;
import org.github.armanddu.boardgame.rule.RuleSet;
import org.github.armanddu.boardgame.stone.StoneType;

public class DoubleThreeRule implements RuleSet {

  public void update(Rule rules) {
    // TODO Auto-generated method stub

  }

  public boolean applies(int nPlayers) {
    // UNUSED
    return false;
  }

  public boolean applies(Board board) {
    // UNUSED
    return false;
  }

  public boolean applies(Board board, StoneType stone, int x, int y) {
    return false;
  }

  public String ReadableRule() {
    // TODO Auto-generated method stub
    return null;
  }

}
