package org.github.armanddu.boardgame.gomoku.rule;

import static org.junit.Assert.*;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.board.BoardDimension;
import org.github.armanddu.boardgame.gomoku.board.GomokuBoard;
import org.github.armanddu.boardgame.gomoku.stone.StoneNode;
import org.github.armanddu.boardgame.rule.Rule;
import org.github.armanddu.boardgame.rule.RuleSet;
import org.github.armanddu.boardgame.stone.StoneType;
import org.junit.Test;

public class gomokuFiveInARowUnbreakableRuleTest {


  @Test
  public void UsingBadApplySurchargeForRuleShouldReturnFalse() throws Exception {
    RuleSet ruleSet = new FiveInaRowUnbreakableRule();

    assertFalse(ruleSet.applies(null, null, 0, 0));
    assertFalse(ruleSet.applies(2));
  }

  @Test
  public void shouldWinIfFiveInARowUnbreakableVerticalConsecutive() throws Exception {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.WHITE;

    board.setStone(stone, 10, 10);
    board.setStone(stone, 10, 11);
    board.setStone(stone, 10, 12);
    board.setStone(stone, 10, 13);
    board.setStone(stone, 10, 14);
    rule.update(board);
    assertTrue(rule.isWinningSet(board));
    assertTrue(rule.isFiveInaRow(board));
    assertTrue(rule.isFiveInaRowUnbreakable(board));
    assertTrue(StoneType.WHITE.equals(rule.getWinningStoneType(board)));

  }

  @Test
  public void shouldWinIfFiveInARowUnbreakableHorizontalConsecutive() throws Exception {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.WHITE;

    board.setStone(stone, 10, 10);
    board.setStone(stone, 11, 10);
    board.setStone(stone, 12, 10);
    board.setStone(stone, 13, 10);
    board.setStone(stone, 14, 10);
    rule.update(board);
    assertTrue(rule.isWinningSet(board));
    assertTrue(rule.isFiveInaRow(board));
    assertTrue(rule.isFiveInaRowUnbreakable(board));
    assertTrue(StoneType.WHITE.equals(rule.getWinningStoneType(board)));

  }

  @Test
  public void shouldWinIfFiveInARowUnbreakableDiagonalCentertoRightBottomConsecutive()
      throws Exception {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.WHITE;

    board.setStone(stone, 10, 10);
    board.setStone(stone, 11, 11);
    board.setStone(stone, 12, 12);
    board.setStone(stone, 13, 13);
    board.setStone(stone, 14, 14);
    rule.update(board);
    assertTrue(rule.isWinningSet(board));
    assertTrue(rule.isFiveInaRow(board));
    assertTrue(rule.isFiveInaRowUnbreakable(board));
    assertTrue(StoneType.WHITE.equals(rule.getWinningStoneType(board)));
  }

  @Test
  public void shouldWinIfFiveInARowUnbreakableCenterToTopLeftConsecutive() throws Exception {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.WHITE;

    board.setStone(stone, 10, 10);
    board.setStone(stone, 9, 9);
    board.setStone(stone, 8, 8);
    board.setStone(stone, 7, 7);
    board.setStone(stone, 6, 6);
    rule.update(board);
    assertTrue(rule.isWinningSet(board));
    assertTrue(rule.isFiveInaRow(board));
    assertTrue(rule.isFiveInaRowUnbreakable(board));
    assertTrue(StoneType.WHITE.equals(rule.getWinningStoneType(board)));

  }

  @Test
  public void shouldWinIfFiveInARowUnbreakableCenterToTopRightConsecutive() throws Exception {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.WHITE;

    board.setStone(stone, 10, 10);
    board.setStone(stone, 11, 9);
    board.setStone(stone, 12, 8);
    board.setStone(stone, 13, 7);
    board.setStone(stone, 14, 6);
    rule.update(board);
    assertTrue(rule.isWinningSet(board));
    assertTrue(rule.isFiveInaRow(board));
    assertTrue(rule.isFiveInaRowUnbreakable(board));
    assertTrue(StoneType.WHITE.equals(rule.getWinningStoneType(board)));

  }

  @Test
  public void shouldWinIfFiveInARowUnbreakableCenterToBottomLeftConsecutive() throws Exception {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.WHITE;

    board.setStone(stone, 10, 10);
    board.setStone(stone, 9, 11);
    board.setStone(stone, 8, 12);
    board.setStone(stone, 7, 13);
    board.setStone(stone, 6, 14);
    rule.update(board);
    assertTrue(rule.isWinningSet(board));
    assertTrue(rule.isFiveInaRow(board));
    assertTrue(rule.isFiveInaRowUnbreakable(board));
    assertTrue(StoneType.WHITE.equals(rule.getWinningStoneType(board)));
  }

  @Test
  public void shoulNotdWinIfFiveInARowBreakableVerticalConsecutive() throws Exception {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.WHITE;

    board.setStone(stone, 10, 10);
    board.setStone(stone, 10, 11);
    board.setStone(stone, 10, 12);
    board.setStone(stone, 10, 13);
    board.setStone(stone, 10, 14);

    board.setStone(StoneType.BLACK, 9, 12);
    board.setStone(stone, 11, 12);

    rule.update(board);
    assertFalse(rule.isWinningSet(board));
    assertTrue(rule.isFiveInaRow(board));
    assertFalse(rule.isFiveInaRowUnbreakable(board));
    assertNull(rule.getWinningStoneType(board));
  }

  @Test
  public void shoulNotdWinIfFiveInARowBreakableHorizontalConsecutive() throws Exception {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(new BoardDimension(6, 6));
    StoneType stone = StoneType.WHITE;

    board.setStone(stone, 1, 3);
    board.setStone(stone, 2, 3);
    board.setStone(stone, 3, 3);
    board.setStone(stone, 4, 3);
    board.setStone(stone, 5, 3);

    board.setStone(StoneType.BLACK, 3, 2);
    board.setStone(stone, 3, 4);

    rule.update(board);
    assertFalse(rule.isWinningSet(board));
    assertTrue(rule.isFiveInaRow(board));
    assertFalse(rule.isFiveInaRowUnbreakable(board));
    assertNull(rule.getWinningStoneType(board));

  }

  @Test
  public void shouldNotWinIfFiveInARowBreakableDiagonalCentertoRightBottomConsecutive()
      throws Exception {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.WHITE;

    board.setStone(stone, 10, 10);
    board.setStone(stone, 11, 11);
    board.setStone(stone, 12, 12);
    board.setStone(stone, 13, 13);
    board.setStone(stone, 14, 14);

    board.setStone(StoneType.BLACK, 13, 11);
    board.setStone(stone, 11, 13);

    rule.update(board);
    assertFalse(rule.isWinningSet(board));
    assertTrue(rule.isFiveInaRow(board));
    assertFalse(rule.isFiveInaRowUnbreakable(board));
    assertNull(rule.getWinningStoneType(board));
  }

  @Test
  public void shoulNotdWinIfFiveInARowBreakableCenterToTopLeftConsecutive() throws Exception {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.WHITE;

    board.setStone(stone, 10, 10);
    board.setStone(stone, 9, 9);
    board.setStone(stone, 8, 8);
    board.setStone(stone, 7, 7);
    board.setStone(stone, 6, 6);

    board.setStone(StoneType.BLACK, 9, 7);
    board.setStone(stone, 7, 9);

    rule.update(board);
    assertFalse(rule.isWinningSet(board));
    assertTrue(rule.isFiveInaRow(board));
    assertFalse(rule.isFiveInaRowUnbreakable(board));
    assertNull(rule.getWinningStoneType(board));

  }

  @Test
  public void shoulNotdWinIfFiveInARowBreakableCenterToTopRightConsecutive() throws Exception {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.WHITE;

    board.setStone(stone, 10, 10);
    board.setStone(stone, 11, 9);
    board.setStone(stone, 12, 8);
    board.setStone(stone, 13, 7);
    board.setStone(stone, 14, 6);

    board.setStone(StoneType.BLACK, 11, 7);
    board.setStone(stone, 13, 9);

    rule.update(board);
    assertFalse(rule.isWinningSet(board));
    assertTrue(rule.isFiveInaRow(board));
    assertFalse(rule.isFiveInaRowUnbreakable(board));
    assertNull(rule.getWinningStoneType(board));
  }

  @Test
  public void shouldNotWinIfFiveInARowBreakableCenterToBottomLeftConsecutive() throws Exception {

    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stone = StoneType.WHITE;

    board.setStone(stone, 10, 10);
    board.setStone(stone, 9, 11);
    board.setStone(stone, 8, 12);
    board.setStone(stone, 7, 13);
    board.setStone(stone, 6, 14);

    board.setStone(StoneType.BLACK, 7, 11);
    board.setStone(stone, 9, 13);
    rule.update(board);
    assertTrue(rule.isFiveInaRow(board));
    assertFalse(rule.isWinningSet(board));
    assertFalse(rule.isFiveInaRowUnbreakable(board));
    assertNull(rule.getWinningStoneType(board));
  }

}
