package com.github.armanddu.boardgames.lib.rule;

import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

public interface StoneRule extends Rule{

  boolean isValid(BoardReader map, StoneMove move);

  
}
