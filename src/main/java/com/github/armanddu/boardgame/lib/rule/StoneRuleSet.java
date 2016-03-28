package com.github.armanddu.boardgame.lib.rule;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

import java.util.Map;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public interface StoneRuleSet extends RuleSet{

    Map<String, StoneRule> getSet();

    Rule getLastInvalid(BoardReader map, StoneMove move);
}
