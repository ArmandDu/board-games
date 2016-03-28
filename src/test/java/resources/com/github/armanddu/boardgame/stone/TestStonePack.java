package resources.com.github.armanddu.boardgame.stone;

import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StonePack;
import com.github.armanddu.boardgame.lib.stone.StoneType;

import java.util.List;

public class TestStonePack implements StonePack {

  private Player owner;

  public void setOwner(Player player) {
    this.owner = player;
  }

  @Override
  public StoneColor getColor() {
    return null;
  }

  @Override
  public List<StoneType> getTypes() {
    return null;
  }

  @Override
  public boolean canUse(StoneType type) {
    return false;
  }

  @Override
  public Stone getStone(StoneType type) {
    return null;
  }

  @Override
  public int getRemaining(StoneType type) {
    return 0;
  }
}
