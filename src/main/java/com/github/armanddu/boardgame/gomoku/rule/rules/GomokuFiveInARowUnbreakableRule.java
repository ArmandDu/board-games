package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.gomoku.stone.GomokuStone;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStoneNode;
import com.github.armanddu.boardgame.lib.stone.*;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.EndGameRule;

import java.util.List;

public class GomokuFiveInARowUnbreakableRule implements EndGameRule {

    @Override
    public String asString() {
        return "Winning rule: A winner is declared if one can align 5 of his stones in a row without your opponent can break it";
    }

    @Override
    public boolean isValid(BoardReader map, StoneMove move) {
        StonePosition position = move.getSuggestedPosition();
        GomokuStone center = new GomokuStone(move.getColor(), position.getX(), position.getY());
        StoneNode node = new GomokuStoneNode(map, center);
        return node.hasWeight(5) && hasNoThreat(node, map);
    }

    private boolean hasNoThreat(StoneNode node, BoardReader map) {
        for (StoneNodeChild childNode : node.getChildren().values()) {
            for (Stone stone: childNode.getStones()) {
                StoneNode child = new GomokuStoneNode(map, stone);
                if (child.geCaptures().size() != 0 || child.getThreats().size() != 0){
                    return false;
                }
            }
        }
        return (node.geCaptures().size() == 0) && (node.getThreats().size() == 0);
    }

}