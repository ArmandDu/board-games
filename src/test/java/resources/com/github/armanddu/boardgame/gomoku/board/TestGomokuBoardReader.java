package resources.com.github.armanddu.boardgame.gomoku.board;

import com.github.armanddu.boardgames.lib.board.Board;
import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.stone.Stone;
import com.github.armanddu.boardgames.lib.stone.StoneColor;

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

  @Override
  public int getScore(StoneColor color) {
    return 0;
  }

  @Override
  public List<Stone> getStones() {
    return null;
  }

}
