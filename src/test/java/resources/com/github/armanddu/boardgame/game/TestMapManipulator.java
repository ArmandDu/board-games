package resources.com.github.armanddu.boardgame.game;

import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

import java.util.List;

public class TestMapManipulator implements BoardReader {

  public TestMapManipulator(Board board) {
    // TODO Auto-generated constructor stub
  }

  public Stone get(int x, int y) {
    // TODO Auto-generated method stub
    return null;
  }

  public int getWidth() {
    // TODO Auto-generated method stub
    return 0;
  }

  public int getHeight() {
    // TODO Auto-generated method stub
    return 0;
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
