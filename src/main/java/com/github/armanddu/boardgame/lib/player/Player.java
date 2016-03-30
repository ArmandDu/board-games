package com.github.armanddu.boardgame.lib.player;

import java.util.List;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePack;

public interface Player {

  String getName();

  StonePack chooseStonePack(List<StonePack> packs);

  Player chooseOpponent(List<Player> opponents);

  StonePack getStonePack();

  StoneColor getStoneColor();

  StoneMove play(BoardReader map);

  boolean isAbandon();

  void abandon();
}
