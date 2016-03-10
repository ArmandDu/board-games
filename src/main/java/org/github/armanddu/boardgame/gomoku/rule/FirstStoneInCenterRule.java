package org.github.armanddu.boardgame.gomoku.rule;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.board.BoardDimension;
import org.github.armanddu.boardgame.rule.Rule;
import org.github.armanddu.boardgame.rule.RuleSet;
import org.github.armanddu.boardgame.stone.StoneType;

public class FirstStoneInCenterRule implements RuleSet {

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
    BoardDimension boardSize = board.getBoardSize();
    return board.getStones().size() != 0
        || x == boardSize.getWidth() / 2 && y == boardSize.getHeight() / 2;
  }

  public String ReadableRule() {
    // TODO Auto-generated method stub
    return null;
  }

}
