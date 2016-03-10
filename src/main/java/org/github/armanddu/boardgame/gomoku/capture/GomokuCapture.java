package org.github.armanddu.boardgame.gomoku.capture;

import java.util.ArrayList;
import java.util.List;

import org.github.armanddu.boardgame.board.Capture;
import org.github.armanddu.boardgame.gomoku.stone.StoneNode;
import org.github.armanddu.boardgame.stone.Stone;
import org.github.armanddu.boardgame.stone.StoneType;

public class GomokuCapture implements Capture {

  private List<Stone> stones;
  private StoneType type;

  public GomokuCapture() {
    this.stones = new ArrayList<Stone>();
    this.type = null;
  }

  public StoneType getStoneType() {
    return this.type;
  }

  public List<Stone> getStones() {
    return this.stones;
  }

  public void setCapture(StoneNode node) {
    this.stones = node.getStones();
    if (!this.stones.isEmpty()) {
      this.type = this.stones.get(0).getType();
    }

  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("GomokuCapture: ").append("size(").append(this.stones.size()).append(")")
        .append(this.stones);
    return builder.toString();
  }

}
