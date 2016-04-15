package com.github.armanddu.boardgames.lib.game;

import java.util.List;

import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.player.Players;
import com.github.armanddu.boardgames.lib.rule.GameRules;
import com.github.armanddu.boardgames.lib.stone.StonePack;

public interface GameBox {

  GameRules getRules();

  List<StonePack> getStonePacks();

  GameManager getManager(Players players);

  Board getBoard();

}
