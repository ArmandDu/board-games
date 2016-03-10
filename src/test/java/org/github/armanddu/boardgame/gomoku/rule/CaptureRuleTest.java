package org.github.armanddu.boardgame.gomoku.rule;

import static org.junit.Assert.*;

import java.util.List;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.board.Capture;
import org.github.armanddu.boardgame.gomoku.board.GomokuBoard;
import org.github.armanddu.boardgame.rule.Rule;
import org.github.armanddu.boardgame.stone.StoneType;
import org.junit.Test;

public class CaptureRuleTest {

  @Test
  public void canCaptureStonesVertical() {
    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stoneW = StoneType.WHITE;
    StoneType stoneB = StoneType.BLACK;

    board.setStone(stoneB, 10, 10);
    rule.update(board);
    board.setStone(stoneW, 10, 11);
    rule.update(board);
    board.setStone(stoneW, 10, 12);
    rule.update(board);
    board.setStone(stoneB, 10, 13);
    rule.update(board);
    List<Capture> captures = rule.getCaptures();
    assertNotNull(captures);
    assertTrue(captures.size() == 1);
    Capture capture = captures.get(0);

    assertEquals(capture.getStones().size(), 2);
    assertTrue(StoneType.WHITE.equals(capture.getStoneType()));
  }

  @Test
  public void canDoubleCaptureStonesVertical() {
    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stoneW = StoneType.WHITE;
    StoneType stoneB = StoneType.BLACK;

    int px = 9;
    board.setStone(stoneB, px, 7);
    rule.update(board);
    board.setStone(stoneW, px, 8);
    rule.update(board);
    board.setStone(stoneW, px, 9);
    rule.update(board);

    board.setStone(stoneW, px, 11);
    rule.update(board);
    board.setStone(stoneW, px, 12);
    rule.update(board);
    board.setStone(stoneB, px, 13);
    rule.update(board);

    board.setStone(stoneB, px, 10);
    rule.update(board);
    List<Capture> captures = rule.getCaptures();
    assertNotNull(captures);
    assertTrue(captures.size() == 2);
    Capture capture = captures.get(0);

    assertEquals(capture.getStones().size(), 2);
    assertTrue(StoneType.WHITE.equals(capture.getStoneType()));

    capture = captures.get(1);
    assertEquals(capture.getStones().size(), 2);
    assertTrue(StoneType.WHITE.equals(capture.getStoneType()));
  }

  @Test
  public void canCaptureStonesVerticalButDontCaptureBlack() {
    Rule rule = new GomokuRules();
    Board board = new GomokuBoard(rule.getBoardSize());
    StoneType stoneW = StoneType.WHITE;
    StoneType stoneB = StoneType.BLACK;

    board.setStone(stoneW, 10, 7);
    rule.update(board);
    board.setStone(stoneB, 10, 8);
    rule.update(board);
    board.setStone(stoneB, 10, 9);
    rule.update(board);

    board.setStone(stoneW, 10, 11);
    rule.update(board);
    board.setStone(stoneW, 10, 12);
    rule.update(board);
    board.setStone(stoneB, 10, 13);
    rule.update(board);

    board.setStone(stoneB, 10, 10);
    rule.update(board);
    List<Capture> captures = rule.getCaptures();
    assertNotNull(captures);
    assertTrue(captures.size() == 1);
    Capture capture = captures.get(0);

    assertEquals(capture.getStones().size(), 2);
    assertTrue(StoneType.WHITE.equals(capture.getStoneType()));

  }

}
