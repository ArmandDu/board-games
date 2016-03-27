package com.github.armanddu.boardgame.game;

import java.util.List;

import com.github.armanddu.boardgame.map.Board;
import com.github.armanddu.boardgame.player.Players;
import com.github.armanddu.boardgame.rule.GameRules;
import com.github.armanddu.boardgame.stone.StonePack;

public interface GameBox {

  GameRules getRules();

  List<StonePack> getStonePack();

  GameManager getManager(Players players);

  Board getBoard();

}
