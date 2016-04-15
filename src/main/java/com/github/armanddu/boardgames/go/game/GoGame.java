package com.github.armanddu.boardgames.go.game;

import java.util.List;

import com.github.armanddu.boardgames.lib.broadcaster.Broadcaster;
import com.github.armanddu.boardgames.lib.game.GameBox;
import com.github.armanddu.boardgames.lib.game.Game;
import com.github.armanddu.boardgames.lib.player.Player;
import com.github.armanddu.boardgames.lib.referee.Referee;

public class GoGame implements Game {


    private final GameBox gameBox;
    private final Referee referee;
    private final Player player;
    private final  List<Player> opponents;
    private final Broadcaster broadcaster;
    private boolean init;
    private boolean started;
    private boolean ended;

    public GoGame(Referee referee, GameBox gameBox, Player player, List<Player> opponents,
                  Broadcaster broadcaster) {
        this.started = false;
        this.ended = false;
        this.init = false;
        this.gameBox = gameBox;
        this.referee = referee;
        this.player = player;
        this.opponents = opponents;
        this.broadcaster = broadcaster;
    }

    public boolean isValid() {
        return referee.isValidGame();
    }

    public boolean isStarted() {
        return this.started;
    }

    public boolean isEnded() {
        return this.ended;
    }

    public void start() {
        this.started = true;
        if (!init) initGame();
        int noPlay = 0;
        int before;
        while (!referee.isEndGame() && noPlay < 25) {
            before = gameBox.getBoard().getStones().size();
            referee.updateGame();
            noPlay = gameBox.getBoard().getStones().size() == before ? noPlay + 1 : 0;
            if (broadcaster != null) broadcaster.broadcast(gameBox.getBoard().getMap(), referee.getLastMove());
        }
        this.ended = referee.isEndGame();
    }

    public void initGame() {
        referee.initGame(this.gameBox, this.player, this.opponents);
        this.init = true;
    }

    public void reset() {
        this.started = false;
        this.ended = false;
    }

}
