package com.github.armanddu.boardgames.lib.stone;

import com.github.armanddu.boardgames.lib.player.Player;
import com.sun.istack.internal.NotNull;

/**
 * Created by armanddu on 31/03/16 for board-games.
 */
public class StoneMoveImpl implements StoneMove {
    protected final Stone stone;
    protected final StonePosition suggested;

    public StoneMoveImpl(int x, int y, Stone stone) {
        this(new StonePositionImpl(x, y), stone);
    }

    public  StoneMoveImpl(StonePosition suggested, @NotNull Stone stone)
    {
        this.suggested = suggested;
        this.stone = stone;
    }

    @Override
    public StonePosition getCurrentPosition() {
        return stone.getPosition();
    }

    @Override
    public StonePosition getSuggestedPosition() {
        return suggested;
    }

    @Override
    public StoneStatus getStatus() {
        return stone.getStatus();
    }

    @Override
    public StoneColor getColor() {
        return stone.getColor();
    }

    @Override
    public StoneType getType() {
        return stone.getType();
    }

    @Override
    public Player getOwner() {
        return stone.getOwner();
    }

    @Override
    public Stone getStone() {
        return stone;
    }
}
