package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.EndGameRule;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

/**
 * Created by armanddu on 29/03/16 for board-games.
 */
public class GomokuOpponentAbandonRule implements EndGameRule {

    /**
     * Super odd algorithm that check for any opponent stone if its owner abandoned. THat means that to be able to give up you need to play at least once
     *
     * @param map
     * @param move
     * @return boolean
     */
    @Override
    public boolean isValid(final BoardReader map, final StoneMove move) {
        return map.getStones().stream()
                .filter(stone -> stone.getColor() != move.getColor())
                .anyMatch(stone -> stone.getOwner().isAbandon());
    }

    @Override
    public String asString() {
        return "Is winner if opponent has abandoned";
    }
}
