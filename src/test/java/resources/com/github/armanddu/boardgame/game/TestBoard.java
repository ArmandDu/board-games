package resources.com.github.armanddu.boardgame.game;

import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

import java.util.List;

public class TestBoard implements Board {

  public Stone get(int x, int y) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void clear() {

  }

  public int getWidth() {
    // TODO Auto-generated method stub
    return 0;
  }

  public int getHeight() {
    // TODO Auto-generated method stub
    return 0;
  }

  public boolean isValidMove(StoneMove move) {
    // TODO Auto-generated method stub
    return false;
  }

  public StoneMove applyMove(StoneMove move) {
    // TODO Auto-generated method stub
    return null;
  }

  public BoardReader getMap() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Stone getLastStone() {
    return null;
  }

  public void setHeight(int height) {
    // TODO Auto-generated method stub
    
  }

  public void setWidth(int width) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public int getScore(StoneColor color) {
    return 0;
  }

  @Override
  public void setScore(StoneColor color, int value) {

  }

  @Override
  public List<Stone> getStones() {
    return null;
  }

}
