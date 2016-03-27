package com.github.armanddu.boardgame.stone;

import java.util.List;

import com.github.armanddu.boardgame.player.Player;

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
