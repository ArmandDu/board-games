package com.github.armanddu.boardgame.player;

import java.util.List;

import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.stone.StoneColor;
import com.github.armanddu.boardgame.stone.StoneMove;
import com.github.armanddu.boardgame.stone.StonePack;

public interface Player {

  String getName();

  List<StonePack> chooseStonePack(List<StonePack> stonePacks);

  Player chooseOponent(List<Player> oponents);

  StonePack getStonePack();

  StoneColor getStoneColor();

  StoneMove play(BoardReader map);

}
