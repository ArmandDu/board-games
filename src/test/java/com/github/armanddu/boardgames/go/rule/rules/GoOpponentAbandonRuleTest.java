package com.github.armanddu.boardgames.go.rule.rules;

import com.github.armanddu.boardgames.lib.rule.EndGameRule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by armanddu on 29/03/16 for board-games.
 */
public class GoOpponentAbandonRuleTest {

    EndGameRule rule = new GoOpponentAbandonRule();

    @Test
    public void testAsString() throws Exception {
    assertNotNull(rule.asString());
    }
}