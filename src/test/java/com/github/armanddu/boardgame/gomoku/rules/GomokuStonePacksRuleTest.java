package com.github.armanddu.boardgame.gomoku.rules;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.github.armanddu.boardgame.game.GameBox;
import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.gomoku.board.GomokuBox;
import com.github.armanddu.boardgame.rule.ConfigRule;
import com.github.armanddu.boardgame.stone.StonePack;

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

}
