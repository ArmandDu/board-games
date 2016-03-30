package com.github.armanddu.boardgame.gomoku.rule.rules;

import static org.junit.Assert.*;

import java.util.List;

import com.github.armanddu.boardgame.lib.rule.Rule;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import org.junit.Test;

import com.github.armanddu.boardgame.lib.game.GameBox;
import com.github.armanddu.boardgame.lib.game.GameManager;
import com.github.armanddu.boardgame.gomoku.board.GomokuBox;
import com.github.armanddu.boardgame.lib.rule.ConfigRule;
import com.github.armanddu.boardgame.lib.stone.StonePack;
import resources.com.github.armanddu.boardgame.gomoku.rules.TestInvalidStonePack;

public class GomokuStonePacksRuleTest {

    @Test
    public void gomokuStonePackShouldBeValidWhenCreated() {
        GameBox gameBox = new GomokuBox();
        GameManager manager = gameBox.getManager(null);
        ConfigRule rule = new GomokuStonePacksRule();

        assertTrue(rule.isValid(manager));
    }

    @Test
    public void emptyStonePackShouldNotBeValid() {
        GameBox gameBox = new GomokuBox();
        GameManager manager = gameBox.getManager(null);
        ConfigRule rule = new GomokuStonePacksRule();
        List<StonePack> packs = manager.getStonePacks();
        packs.clear();
        assertFalse(rule.isValid(manager));
    }

    @Test
    public void emptyStonePackShouldBeValidIfSet() {
        GameBox gameBox = new GomokuBox();
        GameManager manager = gameBox.getManager(null);
        ConfigRule rule = new GomokuStonePacksRule();
        List<StonePack> packs = manager.getStonePacks();
        packs.clear();
        assertFalse(rule.isValid(manager));
        rule.set(manager);
        assertTrue(rule.isValid(manager));
    }

    @Test
    public  void hasRuleAsString()
    {
        Rule rule = new GomokuStonePacksRule();

        assertNotNull(rule.asString());
    }

    @Test
    public  void shouldNotBeValidIfHaveInvalidStoneTypeInPack()
    {
        GameBox gameBox = new GomokuBox();
        GameManager manager = gameBox.getManager(null);
        ConfigRule rule = new GomokuStonePacksRule();
        List<StonePack> packs = manager.getStonePacks();
        packs.clear();
        packs.add(new TestInvalidStonePack(StoneColor.BLACK));
        packs.add(new TestInvalidStonePack(StoneColor.WHITE));
        assertFalse(rule.isValid(manager));
    }

    @Test
    public  void shouldNotBeValidIfHaveInvalidStoneColorInPack()
    {
        GameBox gameBox = new GomokuBox();
        GameManager manager = gameBox.getManager(null);
        ConfigRule rule = new GomokuStonePacksRule();
        List<StonePack> packs = manager.getStonePacks();
        packs.clear();
        packs.add(new TestInvalidStonePack(null));
        packs.add(new TestInvalidStonePack(null));
        assertFalse(rule.isValid(manager));
    }

}
