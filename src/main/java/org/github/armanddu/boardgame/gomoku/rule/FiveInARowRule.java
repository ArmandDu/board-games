package org.github.armanddu.boardgame.gomoku.rule;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.gomoku.stone.StoneNode;
import org.github.armanddu.boardgame.rule.Rule;
import org.github.armanddu.boardgame.rule.RuleSet;
import org.github.armanddu.boardgame.stone.Stone;
import org.github.armanddu.boardgame.stone.StoneType;

public class FiveInARowRule implements RuleSet {


  public void update(Rule rules) {
    rules.setIsFiveInARow(true);
  }

  public boolean applies(Board board) {
    for (Stone stone : board.getStones()) {
      StoneNode maxWeight = stone.getMaxWeight();
      if (maxWeight.size() >= 5) {
        return true;
      }
    }
    return false;
  }

  public String ReadableRule() {
    return "Five in a row rule: ";
  }

  public boolean applies(int nPlayers) {
    // UNUSED
    return false;
  }

  public boolean applies(Board board, StoneType stone, int x, int y) {
    // UNUSED
    return false;
  }


}
