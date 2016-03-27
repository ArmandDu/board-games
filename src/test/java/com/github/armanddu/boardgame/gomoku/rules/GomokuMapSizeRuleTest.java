package com.github.armanddu.boardgame.gomoku.rules;

import static org.junit.Assert.*;

import org.junit.Test;

import com.github.armanddu.boardgame.game.GameBox;
import com.github.armanddu.boardgame.game.GameManager;
import com.github.armanddu.boardgame.gomoku.board.GomokuBox;
import com.github.armanddu.boardgame.rule.ConfigRule;

public class GomokuMapSizeRuleTest {

  @Test
  public void GomokuMapSizeShouldBeValidWhenSizeIs19x19() {

    GameBox map = new GomokuBox();
    GameManager manager = map.getManager(null);
    ConfigRule rule = new GomokuMapSizeRule();

    assertTrue(rule.isValid(manager));
  }

  @Test
  public void GomokuMapSizeShouldBeValidIfSetWithRule() {

    GameBox box = new GomokuBox();
    box.getBoard().setHeight(2);
    box.getBoard().setWidth(2);
    GameManager manager = box.getManager(null);
    ConfigRule rule = new GomokuMapSizeRule();

    assertFalse(rule.isValid(manager));
    rule.set(manager);
    assertTrue(rule.isValid(manager));
  }

}
