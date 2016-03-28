package resources.com.github.armanddu.boardgame.gomoku.player;

import java.util.List;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePack;

public class TestGomokuPlayer implements Player {

  private String name;
  private StoneColor color;

  public TestGomokuPlayer(String name, StoneColor color) {
    this.name = name;
    this.color = color;
  }

  public String getName() {
    return this.name;
  }

  public List<StonePack> chooseStonePack(List<StonePack> packs) {
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
    return this.color;
  }

  public StoneMove play(BoardReader map) {
    // TODO Auto-generated method stub
    return null;
  }

}
