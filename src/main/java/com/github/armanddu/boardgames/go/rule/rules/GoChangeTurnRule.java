package com.github.armanddu.boardgames.go.rule.rules;

import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.StoneRule;
import com.github.armanddu.boardgames.lib.stone.Stone;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

import java.util.List;

public class GoChangeTurnRule implements StoneRule {

    public String asString() {
        return "Change turn rule: Change turn after each stone move.";
    }

    /**
     * is valid if the last move is applied to the board
     * @param map BoardReader
     * @param move StoneMove
     * @return boolean
     */
    public boolean isValid(BoardReader map, StoneMove move) {
        return map != null && move != null && containsStone(map, move);
    }

    private boolean containsStone(BoardReader map, StoneMove move) {
        List<Stone> stones = map.getStones();
        Stone previous = stones.isEmpty() ? null : stones.get(stones.size() -1);
        return previous != null && move.getColor() == previous.getColor();
    }
}
