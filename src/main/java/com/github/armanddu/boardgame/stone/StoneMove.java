package com.github.armanddu.boardgame.stone;

import com.github.armanddu.boardgame.player.Player;

public interface StoneMove {

  StonePosition getCurrentPosition();

  StonePosition getSuggestedPosition();

  StoneStatus getStatus();

  StoneColor getColor();

  StoneType getType();

  Player getOwner();

  Stone getStone();

}
