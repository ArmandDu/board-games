package com.github.armanddu.boardgames.lib.player;

import java.util.List;

import com.github.armanddu.boardgames.lib.game.GameUtils;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePack;

public interface Player {

  String getName();

  StonePack chooseStonePack(List<StonePack> packs);

  Player chooseOpponent(List<Player> opponents);

  StonePack getStonePack();

  StoneColor getStoneColor();

  StoneMove play(GameUtils utils);

  boolean isAbandon();

  void abandon();
}
