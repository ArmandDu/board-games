package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.EndGameRule;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuTenCapturesRule implements EndGameRule {

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
