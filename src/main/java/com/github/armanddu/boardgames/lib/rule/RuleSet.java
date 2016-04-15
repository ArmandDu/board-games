package com.github.armanddu.boardgames.lib.rule;

import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public interface RuleSet {

    boolean isValid(BoardReader map, StoneMove move);
}
