package com.github.armanddu.boardgame.gomoku.rule.rules;

import com.github.armanddu.boardgame.lib.rule.EndGameRule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by armanddu on 29/03/16 for board-games.
 */
public class GomokuOpponentAbandonRuleTest {

    EndGameRule rule = new GomokuOpponentAbandonRule();

    @Test
    public void testAsString() throws Exception {
    assertNotNull(rule.asString());
    }
}