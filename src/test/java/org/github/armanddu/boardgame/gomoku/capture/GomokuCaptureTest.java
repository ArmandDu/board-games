package org.github.armanddu.boardgame.gomoku.capture;

import static org.junit.Assert.*;

import org.github.armanddu.boardgame.board.Capture;
import org.github.armanddu.boardgame.gomoku.stone.GomokuStone;
import org.github.armanddu.boardgame.gomoku.stone.GomokuStoneNode;
import org.github.armanddu.boardgame.stone.StoneType;
import org.junit.Test;

public class GomokuCaptureTest {

  @Test
  public void canStoreCapture() throws Exception {

    GomokuStoneNode node = new GomokuStoneNode();
    Capture capture = new GomokuCapture();

    node.add(new GomokuStone(StoneType.WHITE, 0, 0));
    node.add(new GomokuStone(StoneType.WHITE, 1, 0));
    capture.setCapture(node);
    assertEquals(capture.getStones().size(), 2);
    assertTrue(StoneType.WHITE.equals(capture.getStoneType()));
  }

}
