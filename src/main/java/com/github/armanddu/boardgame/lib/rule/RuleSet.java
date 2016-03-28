package com.github.armanddu.boardgame.lib.rule;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public interface RuleSet {

    boolean isValid(BoardReader map, StoneMove move);
}
