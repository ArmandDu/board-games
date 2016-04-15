package resources.com.github.armanddu.boardgame.game;

import java.util.List;

import com.github.armanddu.boardgames.lib.broadcaster.Broadcaster;
import com.github.armanddu.boardgames.lib.game.Game;
import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.lib.player.Player;
import com.github.armanddu.boardgames.lib.referee.Referee;

public class TestGame implements Game {

  private boolean started;

  public TestGame(Referee referee, GameBox gameBox, Player player, List<Player> opponents,
      Broadcaster broadcaster) {
    this.started = false;
  }

  @Override
  public void initGame() {

  }

  public boolean isValid() {
    return true;
  }

  public boolean isStarted() {
    return this.started;
  }

  public boolean isEnded() {
    return false;
  }

  public void start() {
    this.started = true;
  }

  public void reset() {
    // TODO Auto-generated method stub
    
  }

}
