package com.github.armanddu.boardgame.lib.game;

import java.util.List;

import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.player.Players;
import com.github.armanddu.boardgame.lib.rule.GameRules;
import com.github.armanddu.boardgame.lib.stone.StonePack;

public interface GameBox {

  GameRules getRules();

  List<StonePack> getStonePacks();

  GameManager getManager(Players players);

  Board getBoard();

}
