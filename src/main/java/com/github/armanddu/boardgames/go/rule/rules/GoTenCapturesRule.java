package com.github.armanddu.boardgames.go.rule.rules;

import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.EndGameRule;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GoTenCapturesRule implements EndGameRule {

    public static final int MIN_CAPTURES = 10;

    @Override
    public boolean isValid(final BoardReader map, final StoneMove move) {
        return move != null && map.getScore(move.getColor()) >= MIN_CAPTURES;
    }

    @Override
    public String asString() {
        return String.format("Win Rule:  a player wins the game if  he captures at least %d stones", MIN_CAPTURES);
    }
}
