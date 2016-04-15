package com.github.armanddu.boardgames.lib.stone;

/**
 * Created by armanddu on 30/03/16 for board-games.
 */
public class StonePositionImpl implements StonePosition {

    public static final int POSITION_UNSET = -1;

    protected final int x;
    protected final int y;

    public StonePositionImpl(int x, int y) {
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
