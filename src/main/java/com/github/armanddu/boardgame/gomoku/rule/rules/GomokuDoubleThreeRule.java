package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.gomoku.stone.GomokuStone;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStoneNode;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.rule.StoneRule;
import com.github.armanddu.boardgame.lib.stone.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuDoubleThreeRule implements StoneRule {

    private static final int ALIGNMENT_VALUE = 3;

    @Override
    public boolean isValid(BoardReader map, StoneMove move) {
        StonePosition position = move.getSuggestedPosition();
        StoneNode nodes = new GomokuStoneNode(map, new GomokuStone(move.getColor(), position.getX(), position.getY()));
        List<Map.Entry<String, StoneNodeChild>> matches = nodes.getChildren().entrySet().stream()
                .filter(entry -> entry.getValue().getWeight() == ALIGNMENT_VALUE && entry.getValue().isFree())
                .collect(Collectors.toList());
        return matches.size() < 2 && !checkChildren(map, matches);
    }

    private boolean checkChildren(BoardReader map, List<Map.Entry<String, StoneNodeChild>> matches) {

        return matches.stream()
                .filter(parent -> parent.getValue().getStones().stream()
                        .map(stone -> new GomokuStoneNode(map, stone))
                        .filter(node -> node.getChildren().entrySet().stream()
                                .filter(child -> !Objects.equals(child.getKey(), parent.getKey()))
                                .map(Map.Entry::getValue)
                                .anyMatch(childNode -> childNode.getWeight() == ALIGNMENT_VALUE && childNode.isFree()))
                        .count() > 0)
                .count() > 0;
    }

    @Override
    public String asString() {
        return "Position Rule: Double Three formation are forbidden";
    }
}
