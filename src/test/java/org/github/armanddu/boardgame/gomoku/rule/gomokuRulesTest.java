package org.github.armanddu.boardgame.gomoku.rule;

import static org.junit.Assert.*;

import org.github.armanddu.boardgame.board.BoardDimension;
import org.github.armanddu.boardgame.rule.Rule;
import org.junit.Test;

public class gomokuRulesTest {

  @Test
  public void canHaveGomokuRules() {
    Rule rule = new GomokuRules();

    assertNotNull(rule);
  }

  @Test
  public void ruleShouldHaveGetReadableRules() throws Exception {
    Rule rule = new GomokuRules();

    assertNotNull(rule.getReadableRules());
  }

  @Test
  public void shouldValidateThatNumberOfPlayersIsTwo() throws Exception {
    Rule rule = new GomokuRules();

    assertTrue(rule.isEnoughPlayers(2));
  }

  @Test
  public void shouldReturnFalseIfNotEnoughPlayers() throws Exception {
    Rule rule = new GomokuRules();

    assertFalse(rule.isEnoughPlayers(1));
  }

  @Test
  public void shouldReturnFalseIfNotTooMuchPlayers() throws Exception {
    Rule rule = new GomokuRules();
    assertFalse(rule.isEnoughPlayers(3));

  }

  @Test
  public void shouldBeAbleToGetBoardSizeWhichShouldBe19by19() throws Exception {
    Rule rule = new GomokuRules();
    BoardDimension boardSize = rule.getBoardSize();
    assertEquals(boardSize.getWidth(), 19);
    assertEquals(boardSize.getHeight(), 19);
  }


}
