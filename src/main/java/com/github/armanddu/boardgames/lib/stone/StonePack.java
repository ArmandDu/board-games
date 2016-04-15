package com.github.armanddu.boardgames.lib.stone;

import java.util.List;

public interface StonePack {

  StoneColor getColor();

  List<String> getTypes();

  boolean canUse(StoneType type);

  Stone getStone(StoneType type);

  int getRemaining(StoneType type);

}
