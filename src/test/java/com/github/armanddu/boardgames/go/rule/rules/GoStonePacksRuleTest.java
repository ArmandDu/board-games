package com.github.armanddu.boardgames.go.rule.rules;

import static org.junit.Assert.*;

import java.util.List;

import com.github.armanddu.boardgames.lib.rule.Rule;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import org.junit.Test;

import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.lib.game.GameManager;
import com.github.armanddu.boardgames.go.board.GoBox;
import com.github.armanddu.boardgames.lib.rule.ConfigRule;
import com.github.armanddu.boardgames.lib.stone.StonePack;
import resources.com.github.armanddu.boardgame.gomoku.rules.TestInvalidStonePack;

public class GoStonePacksRuleTest {

    @Test
    public void gomokuStonePackShouldBeValidWhenCreated() {
        GameBox gameBox = new GoBox();
        GameManager manager = gameBox.getManager(null);
        ConfigRule rule = new GoStonePacksRule();

        assertTrue(rule.isValid(manager));
    }

    @Test
    public void emptyStonePackShouldNotBeValid() {
        GameBox gameBox = new GoBox();
        GameManager manager = gameBox.getManager(null);
        ConfigRule rule = new GoStonePacksRule();
        List<StonePack> packs = manager.getStonePacks();
        packs.clear();
        assertFalse(rule.isValid(manager));
    }

    @Test
    public void emptyStonePackShouldBeValidIfSet() {
        GameBox gameBox = new GoBox();
        GameManager manager = gameBox.getManager(null);
        ConfigRule rule = new GoStonePacksRule();
        List<StonePack> packs = manager.getStonePacks();
        packs.clear();
        assertFalse(rule.isValid(manager));
        rule.set(manager);
        assertTrue(rule.isValid(manager));
    }

    @Test
    public  void hasRuleAsString()
    {
        Rule rule = new GoStonePacksRule();

        assertNotNull(rule.asString());
    }

    @Test
    public  void shouldNotBeValidIfHaveInvalidStoneTypeInPack()
    {
        GameBox gameBox = new GoBox();
        GameManager manager = gameBox.getManager(null);
        ConfigRule rule = new GoStonePacksRule();
        List<StonePack> packs = manager.getStonePacks();
        packs.clear();
        packs.add(new TestInvalidStonePack(StoneColor.BLACK));
        packs.add(new TestInvalidStonePack(StoneColor.WHITE));
        assertFalse(rule.isValid(manager));
    }

    @Test
    public  void shouldNotBeValidIfHaveInvalidStoneColorInPack()
    {
        GameBox gameBox = new GoBox();
        GameManager manager = gameBox.getManager(null);
        ConfigRule rule = new GoStonePacksRule();
        List<StonePack> packs = manager.getStonePacks();
        packs.clear();
        packs.add(new TestInvalidStonePack(null));
        packs.add(new TestInvalidStonePack(null));
        assertFalse(rule.isValid(manager));
    }

}
