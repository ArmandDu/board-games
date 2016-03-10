package org.github.armanddu.boardgame.gomoku.rule;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.rule.Rule;
import org.github.armanddu.boardgame.rule.RuleSet;
import org.github.armanddu.boardgame.stone.StoneType;

public class BlackPlaysFirstRule implements RuleSet {

  public void update(Rule rules) {
    // TODO Auto-generated method stub

  }

  public boolean applies(int nPlayers) {
    // TODO Auto-generated method stub
    return false;
  }

  public boolean applies(Board board) {
    // TODO Auto-generated method stub
    return false;
  }

  public boolean applies(Board board, StoneType stone, int x, int y) {
    return board.getStones().size() == 0 ? StoneType.BLACK.equals(stone) : true;
  }

  public String ReadableRule() {
    StringBuilder builder = new StringBuilder();
    return builder.append("Black plays first rule: black must play first").toString();
  }

}
