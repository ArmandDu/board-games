package com.github.armanddu.boardgames.go.rule.rules;

import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.lib.rule.ConfigRule;
import com.github.armanddu.boardgames.lib.stone.StoneColor;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GoStartingPlayerRule implements ConfigRule {

    public static final StoneColor COLOR = StoneColor.BLACK;

    @Override
    public boolean isValid(GameManager manager) {
        return COLOR.equals(manager.getPlayers().getStartingPlayer().getStoneColor());
    }

    @Override
    public void set(GameManager manager) {
        manager.getPlayers().setStartingPlayer(COLOR);
    }

    @Override
    public String asString() {
        return String.format("Starting player rule: %s plays first", COLOR);
    }
}
