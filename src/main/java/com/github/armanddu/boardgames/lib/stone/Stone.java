package com.github.armanddu.boardgames.lib.stone;

import java.util.List;

import com.github.armanddu.boardgames.lib.player.Player;

public interface Stone {

    StoneStatus getStatus();

    StoneColor getColor();

    StoneType getType();

    Player getOwner();

    List<StonePosition> getMovesHistory();

    int getX();

    int getY();

    StonePosition getPosition();

    void apply(StonePosition position);

    void setOwner(Player player);

}
