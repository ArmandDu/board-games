package org.github.armanddu.boardgame.gomoku.rule;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.rule.Rule;
import org.github.armanddu.boardgame.rule.RuleSet;
import org.github.armanddu.boardgame.stone.Stone;
import org.github.armanddu.boardgame.stone.StoneType;

public class StonePositionRule implements RuleSet {

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
    return isInBoundary(board, x, y) && (board.getStones().size() == 0
        || (isNotEmpty(board, x, y, 1, 1) || isNotEmpty(board, x, y, 0, 1)
            || isNotEmpty(board, x, y, -1, 1) || isNotEmpty(board, x, y, -1, 0)
            || isNotEmpty(board, x, y, -1, -1) || isNotEmpty(board, x, y, 0, -1)
            || isNotEmpty(board, x, y, 1, -1) || isNotEmpty(board, x, y, 1, 0)));
  }

  private boolean isNotEmpty(Board board, int x, int y, int i, int j) {
    return isInBoundary(board, x + i, y + j) && board.getBoard()[x + i][y + j] != null;
  }

  private boolean isInBoundary(Board board, int x, int y) {
    Stone[][] map = board.getBoard();
    System.out
        .println(x + ":" + y + "= " + (x >= 0 && y >= 0 && x < map.length && y < map[x].length));
    return x >= 0 && y >= 0 && x < map.length && y < map[x].length;
  }

  public String ReadableRule() {
    StringBuilder builder = new StringBuilder();
    return builder.append("Stone Position Rule: ").append("\n\t")
        .append("First Move must be placed in center of the board").append("\n\t")
        .append("new stones must be placed next to an other one").toString();
  }

}
