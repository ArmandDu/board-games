package com.github.armanddu.boardgames.lib.rule;

import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

public interface EndGameRule extends Rule {

  boolean isValid(final BoardReader map, final StoneMove move);

}
