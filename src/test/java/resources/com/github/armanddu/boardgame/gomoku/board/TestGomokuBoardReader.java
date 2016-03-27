package resources.com.github.armanddu.boardgame.gomoku.board;

import com.github.armanddu.boardgame.map.Board;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneMove;

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

  public boolean isValidMove(int x, int y) {
    // TODO Auto-generated method stub
    return false;
  }

}
