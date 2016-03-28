package com.github.armanddu.boardgame.lib.rule;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

public interface EndGameRule extends Rule {

  boolean isValid(BoardReader map, StoneMove move);

}
