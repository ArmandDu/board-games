package org.github.armanddu.boardgame.gomoku.rule;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.rule.Rule;
import org.github.armanddu.boardgame.rule.RuleSet;
import org.github.armanddu.boardgame.stone.StoneType;

public class PlayerRuleSet implements RuleSet {

  public void update(Rule rules) {}

  public boolean applies(int nPlayers) {
    return nPlayers == 2;
  }

  public String ReadableRule() {
    return "Player Rule: required number of players: 2";
  }

  public boolean applies(Board board) {
    // TODO Auto-generated method stub
    return false;
  }

  public boolean applies(Board board, StoneType stone, int x, int y) {
    // TODO Auto-generated method stub
    return false;
  }

}
