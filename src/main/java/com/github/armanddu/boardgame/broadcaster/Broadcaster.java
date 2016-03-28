package com.github.armanddu.boardgame.broadcaster;

import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.stone.StoneMove;

public interface Broadcaster {

    void broadcast(BoardReader map, StoneMove lastMove);
}
