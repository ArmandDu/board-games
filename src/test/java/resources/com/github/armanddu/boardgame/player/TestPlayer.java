package resources.com.github.armanddu.boardgame.player;

import java.util.List;

import com.github.armanddu.boardgames.lib.game.GameUtils;
import com.github.armanddu.boardgames.lib.player.Player;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StoneMove;
import com.github.armanddu.boardgames.lib.stone.StonePack;

public class TestPlayer implements Player {

  private String name;

  public TestPlayer(String name) {
    this.setName(name);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public StonePack chooseStonePack(List<StonePack> packs) {
    // TODO Auto-generated method stub
    return null;
  }

  public Player chooseOpponent(List<Player> opponents) {
    // TODO Auto-generated method stub
    return null;
  }

  public StonePack getStonePack() {
    // TODO Auto-generated method stub
    return null;
  }

  public StoneColor getStoneColor() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public StoneMove play(GameUtils utils) {
    return null;
  }

  @Override
  public boolean isAbandon() {
    return false;
  }

  @Override
  public void abandon() {

  }

}
