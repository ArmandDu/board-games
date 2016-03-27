package com.github.armanddu.boardgame.player;

import java.util.List;
import java.util.Map;

import com.github.armanddu.boardgame.stone.StoneColor;

public interface Players {

  void setWhite(Player player1);

  void setBlack(Player player2);

  Player getWhite();

  Player getBlack();

  List<Player> asList();

  Map<StoneColor, Player> asMap();

  Player get(StoneColor color);

}
