package com.github.armanddu.boardgame.gomoku.stone;

import com.github.armanddu.boardgame.lib.stone.StonePosition;

public class GomokuStonePosition implements StonePosition {

  private final int x;
  private final int y;

  public GomokuStonePosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

}
