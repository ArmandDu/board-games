package com.github.armanddu.boardgames.lib.game;

import java.util.List;

import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.player.Players;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePack;

public interface GameManager {

    Board getBoard();

    BoardReader getMap();

    Players getPlayers();

    void updateStatus(StoneMove move);

    List<StonePack> getStonePacks();

}
