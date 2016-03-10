package org.github.armanddu.boardgame.gomoku.rule;

import static org.junit.Assert.*;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.gomoku.board.GomokuBoard;
import org.github.armanddu.boardgame.rule.Rule;
import org.github.armanddu.boardgame.rule.RuleSet;
import org.github.armanddu.boardgame.stone.StoneType;
import org.junit.Test;

public class gomokuPlaceStoneRuleTest {

  @Test
  public void UsingBadApplySurchargeForStonePositionRuleShouldReturnFalse() throws Exception {
    RuleSet ruleSet = new StonePositionRule();

    assertFalse(ruleSet.applies(null));
    assertFalse(ruleSet.applies(2));
  }

  @Test
  public void stoneCannotBePlacedOutsideTheCenterOfBoardToBegin() {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.BLACK;
    assertFalse(rule.isValidMove(board, stone, 0, 0));
  }

  @Test
  public void blackMustPlayFirst() throws Exception {
    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());

    assertTrue(rule.isValidMove(board, StoneType.BLACK, 9, 9));
    assertFalse(rule.isValidMove(board, StoneType.WHITE, 9, 9));
  }

  @Test
  public void stoneCannotBePlacedOutsideTheBoardBoundaries() {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.BLACK;
    assertFalse(rule.isValidMove(board, stone, -1, 0));
    assertFalse(rule.isValidMove(board, stone, -1, -1));
    assertFalse(rule.isValidMove(board, stone, 19, -1));
    assertFalse(rule.isValidMove(board, stone, 19, 0));
    assertFalse(rule.isValidMove(board, stone, 19, 19));
    assertFalse(rule.isValidMove(board, stone, -1, 19));
    assertFalse(rule.isValidMove(board, stone, 0, 19));
    assertFalse(rule.isValidMove(board, stone, 0, -1));
  }

  @Test
  public void stoneCanBePlacedInTheCenterOfBoardToBegin() {
    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.BLACK;

    assertTrue(rule.isValidMove(board, stone, 9, 9));
  }

  @Test
  public void stoneCannotBePlacedIfNotConnectedToOtherStones() {
    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType white = StoneType.WHITE;
    StoneType black = StoneType.BLACK;

    board.setStone(white, 10, 10);

    assertFalse(rule.isValidMove(board, white, 12, 12));
    assertFalse(rule.isValidMove(board, black, 12, 12));

    assertFalse(rule.isValidMove(board, white, 10, 12));
    assertFalse(rule.isValidMove(board, black, 10, 12));


    assertFalse(rule.isValidMove(board, white, 12, 10));
    assertFalse(rule.isValidMove(board, black, 12, 10));

    assertFalse(rule.isValidMove(board, white, 12, 8));
    assertFalse(rule.isValidMove(board, black, 12, 8));

    assertFalse(rule.isValidMove(board, white, 10, 8));
    assertFalse(rule.isValidMove(board, black, 10, 8));

    assertFalse(rule.isValidMove(board, white, 8, 8));
    assertFalse(rule.isValidMove(board, black, 8, 8));

    assertFalse(rule.isValidMove(board, white, 8, 10));
    assertFalse(rule.isValidMove(board, black, 8, 10));

    assertFalse(rule.isValidMove(board, white, 8, 12));
    assertFalse(rule.isValidMove(board, black, 8, 12));
  }

  @Test
  public void stoneCanBePlacedIfConnectedToOtherStones() {
    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType white = StoneType.WHITE;
    StoneType black = StoneType.BLACK;

    board.setStone(white, 10, 10);

    assertTrue(rule.isValidMove(board, white, 11, 11));
    assertTrue(rule.isValidMove(board, black, 11, 11));

    assertTrue(rule.isValidMove(board, white, 10, 11));
    assertTrue(rule.isValidMove(board, black, 10, 11));


    assertTrue(rule.isValidMove(board, white, 11, 10));
    assertTrue(rule.isValidMove(board, black, 11, 10));

    assertTrue(rule.isValidMove(board, white, 11, 9));
    assertTrue(rule.isValidMove(board, black, 11, 9));

    assertTrue(rule.isValidMove(board, white, 10, 9));
    assertTrue(rule.isValidMove(board, black, 10, 9));

    assertTrue(rule.isValidMove(board, white, 9, 9));
    assertTrue(rule.isValidMove(board, black, 9, 9));

    assertTrue(rule.isValidMove(board, white, 9, 10));
    assertTrue(rule.isValidMove(board, black, 9, 10));

    assertTrue(rule.isValidMove(board, white, 9, 11));
    assertTrue(rule.isValidMove(board, black, 9, 11));
  }


}
