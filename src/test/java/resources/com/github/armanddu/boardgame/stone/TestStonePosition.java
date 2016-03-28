package resources.com.github.armanddu.boardgame.stone;

import com.github.armanddu.boardgame.lib.stone.StonePosition;

public class TestStonePosition implements StonePosition {

  private int x;
  private int y;

  public TestStonePosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    // TODO Auto-generated method stub
    return y;
  }

}
