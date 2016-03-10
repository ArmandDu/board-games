package org.github.armanddu.boardgame.gomoku.stone;

import java.util.ArrayList;
import java.util.List;

import org.github.armanddu.boardgame.stone.Stone;

public class GomokuStoneNode implements StoneNode {

  private List<Stone> nodes;
  private boolean threat;

  public GomokuStoneNode() {
    this.reset();
  }

  public void reset() {
    this.nodes = new ArrayList<Stone>();
    this.threat = false;
  }

  public void add(Stone stone) {
    this.nodes.add(stone);
  }

  public void setThreat(boolean threat) {
    this.threat = threat;
  }

  public int size() {
    return this.nodes.size();
  }

  public boolean isThreatened() {
    return this.threat;
  }

  public List<Stone> getStones() {
    return this.nodes;
  }

  public boolean isCapture(Stone stone) {
    return false;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("GomokuStoneNode: ").append("size(").append(this.nodes.size()).append(")")
        .append(" threatened(").append(this.threat).append(")").append(this.nodes);
    return builder.toString();
  }

}
