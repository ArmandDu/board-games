package com.github.armanddu.boardgame.lib.broadcaster;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

public interface Broadcaster {

    void broadcast(BoardReader map, StoneMove last);
}
