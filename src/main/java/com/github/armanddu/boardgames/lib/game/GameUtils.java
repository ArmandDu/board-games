package com.github.armanddu.boardgames.lib.game;

import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

/**
 * Created by armanddu on 01/04/16 for board-games.
 */
public interface GameUtils {

    BoardReader getMap();

    boolean isValidMove(StoneMove move);
}
