package com.github.armanddu.boardgames.lib.broadcaster;

import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

public interface Broadcaster {

    void broadcast(BoardReader map, StoneMove last);
}
