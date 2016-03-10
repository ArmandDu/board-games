package org.github.armanddu.boardgame.gomoku.rule;

import java.util.ArrayList;
import java.util.List;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.board.Capture;
import org.github.armanddu.boardgame.gomoku.capture.GomokuCapture;
import org.github.armanddu.boardgame.gomoku.stone.StoneNode;
import org.github.armanddu.boardgame.rule.Rule;
import org.github.armanddu.boardgame.rule.RuleSet;
import org.github.armanddu.boardgame.stone.Stone;
import org.github.armanddu.boardgame.stone.StoneType;

public class CaptureRule implements RuleSet {

  private List<Capture> captures;


  public CaptureRule() {
    this.captures = new ArrayList<Capture>();
  }

  public void update(Rule rules) {
    rules.setCaptures(this.captures);
  }

  public boolean applies(int nPlayers) {
    // TODO Auto-generated method stub
    return false;
  }

  public boolean applies(Board board) {
    List<Stone> stones = board.getStones();
    if (stones.size() < 2) {
      return false;
    }
    Stone lastStone = board.getLastStone();
    checkCapture(board, lastStone, -1, -1);
    checkCapture(board, lastStone, -1, 0);
    checkCapture(board, lastStone, -1, 1);

    checkCapture(board, lastStone, 0, -1);
    checkCapture(board, lastStone, 0, 1);

    checkCapture(board, lastStone, 1, -1);
    checkCapture(board, lastStone, 1, 0);
    checkCapture(board, lastStone, 1, 1);
    return !this.captures.isEmpty();
  }

  public boolean applies(Board board, StoneType stone, int x, int y) {
    // TODO Auto-generated method stub
    return false;
  }

  public String ReadableRule() {
    return "Capture Rule: the Oponnent can capute a pair of enemy stone with two of its own";
  }


  private void checkCapture(Board board, Stone lastStone, int dx, int dy) {
    Stone[][] map = board.getBoard();
    int x = lastStone.getX() + dx;
    int y = lastStone.getY() + dy;
    if (!board.isInBoundaries(x, y)) {
      return;
    }
    Stone stone = map[x][y];
    if (stone != null && stone.getType() != lastStone.getType()) {
      for (StoneNode node : stone.getNodes()) {
        System.out.println(node);
        if (node.isThreatened()) {
          Capture capture = new GomokuCapture();
          capture.setCapture(node);
          System.out.println("CAPTURED: " + capture);
          this.captures.add(capture);
        }
      }
    }
  }


}
