package com.github.armanddu.boardgames.go.rule.rules;

import static org.junit.Assert.*;

import com.github.armanddu.boardgames.lib.rule.Rule;
import org.junit.Test;

import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.go.board.GoBox;
import com.github.armanddu.boardgames.lib.rule.ConfigRule;

public class GoMapSizeRuleTest {

    @Test
    public void GomokuMapSizeShouldBeValidWhenSizeIs19x19() {

        GameBox map = new GoBox();
        GameManager manager = map.getManager(null);
        ConfigRule rule = new GoMapSizeRule();

        assertTrue(rule.isValid(manager));
    }

    @Test
    public void GomokuMapSizeShouldBeValidIfSetWithRule() {

        GameBox box = new GoBox();
        box.getBoard().setHeight(2);
        box.getBoard().setWidth(2);
        GameManager manager = box.getManager(null);
        ConfigRule rule = new GoMapSizeRule();

        assertFalse(rule.isValid(manager));
        rule.set(manager);
        assertTrue(rule.isValid(manager));
    }

@Test
    public  void hasRuleAsString()
{
    Rule rule = new GoMapSizeRule();

    assertNotNull(rule.asString());
}

}
