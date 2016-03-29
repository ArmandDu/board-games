package com.github.armanddu.boardgame.gomoku.stone;

import java.util.ArrayList;
import java.util.List;

import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StonePosition;
import com.github.armanddu.boardgame.lib.stone.StoneStatus;
import com.github.armanddu.boardgame.lib.stone.StoneType;

public class GomokuStone implements Stone {

    private final List<StonePosition> history;
    private final StoneType type;
    private final StoneColor color;
    private final StoneStatus status;
    private StonePosition position;
    private Player owner;

    public GomokuStone(StoneColor color, int x, int y) {
        this.type = new GomokuStoneType();
        this.color = color;
        this.status = null;
        this.owner = null;
        this.history = new ArrayList<>();
        this.position = new GomokuStonePosition(x, y);
    }

    public StoneStatus getStatus() {
        return this.status;
    }

    public StoneColor getColor() {
        return this.color;
    }

    public StoneType getType() {
        return this.type;
    }

    public Player getOwner() {
        return this.owner;
    }

    public List<StonePosition> getMovesHistory() {
        return this.history;
    }

    public int getX() {
        return this.getPosition().getX();
    }

    public int getY() {
        return this.getPosition().getY();
    }

    public StonePosition getPosition() {
        return this.position;
    }

    public void apply(StonePosition suggestedPosition) {
        this.history.add(this.position);
        this.position = suggestedPosition;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "GomokuStone [" + color + "/" + type.type() + "] in position: " + getX() + "/" + getY();
    }

}
