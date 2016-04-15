package com.github.armanddu.boardgames.lib.stone;

import com.github.armanddu.boardgames.lib.player.Player;

public interface StoneMove {

  StonePosition getCurrentPosition();

  StonePosition getSuggestedPosition();

  StoneStatus getStatus();

  StoneColor getColor();

  StoneType getType();

  Player getOwner();

  Stone getStone();

}
