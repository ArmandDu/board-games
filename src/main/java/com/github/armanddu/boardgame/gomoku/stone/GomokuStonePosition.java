package com.github.armanddu.boardgame.gomoku.stone;

import com.github.armanddu.boardgame.stone.StonePosition;

public class GomokuStonePosition implements StonePosition {

  private int x;
  private int y;

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
