package resources.com.github.armanddu.boardgame.gomoku.board;

import com.github.armanddu.boardgame.gomoku.board.GomokuBoardReader;
import com.github.armanddu.boardgame.map.Board;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneMove;
import com.github.armanddu.boardgame.stone.StonePosition;

public class TestGomokuBoardMap implements Board {

  private Stone[][] map;
  private int width;
  private int height;
  private BoardReader reader;

  public TestGomokuBoardMap() {
    this.width = 7;
    this.height = 7;
    this.map = new Stone[this.width][this.height];
    this.reader = new GomokuBoardReader(this);
  }

  public Stone get(int x, int y) {
    if (isInBoundaries(x, y)) {
      return this.map[x][y];
    }
    return null;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public boolean isValidMove(StoneMove stoneMove) {
    return true;
  }

  public void applyMove(StoneMove stoneMove) {
    StonePosition suggestedPosition = stoneMove.getSuggestedPosition();
    Stone stone = stoneMove.getStone();
    put(suggestedPosition, stone);
    stone.apply(suggestedPosition);
  }

  private void put(StonePosition suggestedPosition, Stone stone) {
    this.map[suggestedPosition.getX()][suggestedPosition.getY()] = stone;
  }

  public BoardReader getMap() {
    return this.reader;
  }

  private boolean isInBoundaries(int x, int y) {
    return x >= 0 && y >= 0 && x < this.width && y < this.height;
  }

  public void setHeight(int height) {
    this.height = height;
    this.map = new Stone[this.width][this.height];
  }

  public void setWidth(int width) {
    this.width = width;
    this.map = new Stone[this.width][this.height];
  }

}
