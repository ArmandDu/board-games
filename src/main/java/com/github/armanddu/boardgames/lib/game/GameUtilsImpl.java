package com.github.armanddu.boardgames.lib.game;

import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.rule.GameRules;
import com.github.armanddu.boardgames.lib.stone.StoneMove;

/**
 * Created by armanddu on 01/04/16 for board-games.
 */
public class GameUtilsImpl implements GameUtils {

    private final GameRules rules;
    private final BoardReader map;

    public GameUtilsImpl(GameRules rules, BoardReader map) {
        this.rules = rules;
        this.map = map;
    }

    @Override
    public BoardReader getMap() {
        return map;
    }

    @Override
    public boolean isValidMove(StoneMove move) {
        return rules.isValidMove(map, move);
    }
}
