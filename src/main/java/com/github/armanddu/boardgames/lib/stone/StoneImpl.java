package com.github.armanddu.boardgames.lib.stone;

import com.github.armanddu.boardgames.lib.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by armanddu on 30/03/16 for board-games.
 */
public class StoneImpl implements Stone {
    protected final List<StonePosition> history;
    protected final StoneType type;
    protected final StoneColor color;
    protected final StoneStatus status;
    protected StonePosition position;
    protected Player owner;

    public StoneImpl(int x, int y, StoneColor color, StoneType type) {
        this(x, y, color, type, null);
    }

    public StoneImpl(int x, int y, StoneColor color, StoneType type, Player owner) {
        this(new StonePositionImpl(x, y), color, type, owner);
    }

    public  StoneImpl(StonePosition position, StoneColor color, StoneType type, Player owner) {
        this.history = new ArrayList<>();
        this.position = position;
        this.color = color;
        this.status = null;
        this.type = type;
        this.owner = owner;
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
        return Collections.unmodifiableList(this.history);
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

    public void apply(StonePosition position) {
        this.history.add(this.position);
        this.position = position;
    }

    public void setOwner(Player owner) {
        if (this.owner == null) this.owner = owner;
    }

    @Override
    public String toString() {
        return "[" + color + "/" + type.type() + "] in position: " + getX() + "/" + getY();
    }

}
