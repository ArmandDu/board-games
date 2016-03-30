package resources.com.github.armanddu.boardgame.gomoku.player;

import java.util.List;
import java.util.stream.Collectors;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePack;

public class TestGomokuPlayer implements Player {

    private String name;
    private StoneColor color;
    private StonePack pack;
    private boolean giveUp;

    public TestGomokuPlayer(String name, StoneColor color) {
        this.name = name;
        this.color = color;
        this.giveUp = false;
    }

    public String getName() {
        return this.name;
    }

    public StonePack chooseStonePack(List<StonePack> packs) {
        pack = packs.stream().filter(pack -> pack.getColor() == color).findFirst().get();
        return pack;
    }

    public Player chooseOpponent(List<Player> opponents) {
        return opponents.get(0);
    }

    public StonePack getStonePack() {
        return pack;
    }

    public StoneColor getStoneColor() {
        return this.color;
    }

    public StoneMove play(BoardReader map) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAbandon() {
        return this.giveUp;
    }

    @Override
    public void abandon() {
        this.giveUp = true;
    }

}
