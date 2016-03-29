package com.github.armanddu.boardgame.gomoku.stone;

import com.github.armanddu.boardgame.lib.player.Player;
import com.github.armanddu.boardgame.lib.stone.*;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuStoneMove implements StoneMove {

    private final Stone stone;
    private final StonePosition suggested;

    public GomokuStoneMove(Stone stone, int x, int y) {
        this.stone = stone;
        this.suggested = new GomokuStonePosition(x, y);
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
