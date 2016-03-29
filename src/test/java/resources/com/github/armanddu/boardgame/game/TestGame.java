package resources.com.github.armanddu.boardgame.game;

import java.util.List;

import com.github.armanddu.boardgame.lib.broadcaster.Broadcaster;
import com.github.armanddu.boardgame.lib.game.Game;
import com.github.armanddu.boardgame.lib.game.GameBox;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.referee.Referee;

public class TestGame implements Game {

  private boolean started;

  public TestGame(Referee referee, GameBox gameBox, Player player, List<Player> opponents,
      Broadcaster broadcaster) {
    this.started = false;
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
