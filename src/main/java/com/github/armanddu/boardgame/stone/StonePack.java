package com.github.armanddu.boardgame.stone;

import java.util.List;

public interface StonePack {

  StoneColor getColor();

  List<StoneType> getTypes();

  boolean canUse(StoneType type);

  Stone getStone(StoneType type);

  int getRemaining(StoneType type);

}
