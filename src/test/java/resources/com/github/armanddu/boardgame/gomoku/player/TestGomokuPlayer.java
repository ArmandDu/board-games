package resources.com.github.armanddu.boardgame.gomoku.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.github.armanddu.boardgame.gomoku.stone.GomokuStone;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStoneMove;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;
import com.github.armanddu.boardgame.lib.stone.StonePack;
import com.github.armanddu.boardgame.lib.stone.StonePosition;

import javax.swing.text.Position;

public class TestGomokuPlayer implements Player {

    private final List<StonePosition> moves;
    private String name;
    private StoneColor color;
    private StonePack pack;
    private boolean giveUp;

    public TestGomokuPlayer(String name, StoneColor color) {
        this(name, color, new ArrayList<>());
    }

    public TestGomokuPlayer(String name, StoneColor color, List<StonePosition> moves) {
        this.name = name;
        this.color = color;
        this.giveUp = false;
        this.moves = moves;
    }

    public String getName() {
        return this.name;
    }

    public StonePack chooseStonePack(List<StonePack> packs) {
        Optional<StonePack> first = packs.stream().filter(pack -> pack.getColor() == color).findFirst();
        pack = first.isPresent() ? first.get() : null;
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
        if (moves.isEmpty()) return null;
        StonePosition pos = moves.get(0);
        StoneMove move = new GomokuStoneMove(new GomokuStone(color, 0, 0), pos.getX(), pos.getY());
        moves.remove(0);
        return move;
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
