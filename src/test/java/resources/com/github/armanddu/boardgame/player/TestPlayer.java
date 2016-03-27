package resources.com.github.armanddu.boardgame.player;

import java.util.List;

import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.player.Player;
import com.github.armanddu.boardgame.stone.StoneColor;
import com.github.armanddu.boardgame.stone.StoneMove;
import com.github.armanddu.boardgame.stone.StonePack;

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

  public List<StonePack> chooseStonePack(List<StonePack> stonePacks) {
    // TODO Auto-generated method stub
    return null;
  }

  public Player chooseOponent(List<Player> oponents) {
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

  public StoneMove play(BoardReader map) {
    // TODO Auto-generated method stub
    return null;
  }

}
