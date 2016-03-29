package resources.com.github.armanddu.boardgame.gomoku.board;

import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

import java.util.List;

public class TestGomokuBoardReader implements BoardReader {

  private Board map;

  public TestGomokuBoardReader(Board map) {
    this.map = map;
  }

  public Stone get(int x, int y) {
    return this.map.get(x, y);
  }

  public int getWidth() {
    return map.getWidth();
  }

  public int getHeight() {
    // TODO Auto-generated method stub
    return map.getHeight();
  }

  public boolean isValidMove(StoneMove stoneMove) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int getScore(StoneColor color) {
    return 0;
  }

  @Override
  public List<Stone> getStone() {
    return null;
  }

  public boolean isValidMove(int x, int y) {
    // TODO Auto-generated method stub
    return false;
  }

}
