package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.lib.rule.Rule;
import com.github.armanddu.boardgame.lib.rule.StoneRule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuChangeTurnRuleTest {

    @Test
    public void testAsString() throws Exception {
        Rule rule = new GomokuChangeTurnRule();

        assertNotNull(rule.asString());
    }

    @Test
    public  void shouldAlwaysBeValid()
    {
        StoneRule rule = new GomokuChangeTurnRule();

        assertTrue(rule.isValid(null, null));
    }
}