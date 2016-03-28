package com.github.armanddu.boardgame.lib.stone;

import java.util.List;

import com.github.armanddu.boardgame.lib.player.Player;

public interface Stone {

  StoneStatus getStatus();

  StoneColor getColor();

  StoneType getType();

  Player getOwner();

  List<StonePosition> getMovesHistory();

  int getX();

  int getY();

  StonePosition getPosition();

  void apply(StonePosition suggestedPosition);

  void setOwner(Player player);

}
