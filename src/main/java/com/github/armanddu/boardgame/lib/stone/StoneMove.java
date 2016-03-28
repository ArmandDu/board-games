package com.github.armanddu.boardgame.lib.stone;

import com.github.armanddu.boardgame.lib.player.Player;

public interface StoneMove {

  StonePosition getCurrentPosition();

  StonePosition getSuggestedPosition();

  StoneStatus getStatus();

  StoneColor getColor();

  StoneType getType();

  Player getOwner();

  Stone getStone();

}
