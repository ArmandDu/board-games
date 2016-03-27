package com.github.armanddu.boardgame.gomoku.stone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneColor;
import com.github.armanddu.boardgame.stone.StonePack;
import com.github.armanddu.boardgame.stone.StoneType;

public class GomokuStonePack implements StonePack {

  private static final int UNSET_X = -1;
  private static final int UNSET_Y = -1;
  private static final int UNLIMITED = -1;
  private Map<StoneType, Integer> stones;
  private StoneColor color;

  public GomokuStonePack(StoneColor color) {
    this.stones = new HashMap<>();
    this.color = color;
    this.stones.put(new GomokuStoneType(), UNLIMITED);
  }

  public boolean canUse(StoneType type) {
    Integer quantity = stones.getOrDefault(type, 0);
    return quantity == UNLIMITED || quantity > 0;
  }

  public Stone getStone(StoneType type) {
    if (canUse(type)) {
      reduce(type);
      return new GomokuStone(getColor(), UNSET_X, UNSET_Y);
    }
    return null;
  }

  private void reduce(StoneType type) {
    Integer quantity = stones.getOrDefault(type, 0);
    if (quantity != UNLIMITED && quantity > 0) {
      stones.put(type, quantity - 1);
    }
  }

  public StoneColor getColor() {
    return this.color;
  }

  public List<StoneType> getTypes() {
    return new ArrayList<>(this.stones.keySet());
  }

  public int getRemaining(StoneType type) {
    Integer quantity = stones.getOrDefault(type, 0);
    return quantity == UNLIMITED ? 999999  : quantity;
  }

}
