package com.github.armanddu.boardgame.lib.game;

import java.util.List;

import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.player.Players;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePack;

public interface GameManager {

    Board getBoard();

    BoardReader getMap();

    Players getPlayers();

    StoneColor getNextTurn();

    void updateStatus(StoneMove move);

    List<StonePack> getStonePacks();

}
