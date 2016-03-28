package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.lib.rule.ConfigRule;
import com.github.armanddu.boardgame.lib.stone.StoneColor;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuStartingPlayerRule implements ConfigRule {

    private static final StoneColor color = StoneColor.BLACK;

    @Override
    public boolean isValid(GameManager manager) {
        return color.equals(manager.getPlayers().getStartingPlayer().getStoneColor());
    }

    @Override
    public void set(GameManager manager) {
        manager.getPlayers().setStartingPlayer(color);
    }

    @Override
    public String asString() {
        return String.format("Starting player rule: %s plays first", color);
    }
}
