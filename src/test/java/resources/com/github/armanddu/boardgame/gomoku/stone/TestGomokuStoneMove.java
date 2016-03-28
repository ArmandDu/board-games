package resources.com.github.armanddu.boardgame.gomoku.stone;

import com.github.armanddu.boardgame.gomoku.stone.GomokuStone;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStonePosition;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePosition;
import com.github.armanddu.boardgame.lib.stone.StoneStatus;
import com.github.armanddu.boardgame.lib.stone.StoneType;

public class TestGomokuStoneMove implements StoneMove {

  private StonePosition suggested;
  private GomokuStone stone;

  public TestGomokuStoneMove(int x, int y) {
   this(StoneColor.WHITE, x, y);
  }

  public TestGomokuStoneMove(StoneColor color, int x, int y) {
    this.suggested = new GomokuStonePosition(x, y);
    this.stone = new GomokuStone(color, -1, -1);
  }

  public StonePosition getCurrentPosition() {
    // TODO Auto-generated method stub
    return null;
  }

  public StonePosition getSuggestedPosition() {
    return suggested;
  }

  public StoneStatus getStatus() {
    // TODO Auto-generated method stub
    return null;
  }

  public StoneColor getColor() {
    return stone.getColor();
  }

  public StoneType getType() {
    return stone.getType();
  }

  public Player getOwner() {
    return stone.getOwner();
  }

  public Stone getStone() {
    return stone;
  }

}
