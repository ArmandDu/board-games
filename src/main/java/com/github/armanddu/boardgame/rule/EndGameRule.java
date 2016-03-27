package com.github.armanddu.boardgame.rule;

import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.stone.StoneMove;

public interface EndGameRule extends Rule {

  boolean isValid(BoardReader map, StoneMove stoneMove);

}
