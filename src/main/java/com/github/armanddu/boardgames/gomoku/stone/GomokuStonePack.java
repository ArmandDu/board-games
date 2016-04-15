package com.github.armanddu.boardgames.gomoku.stone;

import com.github.armanddu.boardgames.lib.stone.*;

public class GomokuStonePack extends AbstractStonePack {

    public GomokuStonePack(StoneColor color) {
        super(color);
        getStocks().put(GomokuStoneType.type, UNLIMITED);
    }


    @Override
    public Stone getStone(StoneType type) {
        if (canUse(type)) {
            reduce(type);
            return new GomokuStone(getColor(), GomokuStonePosition.POSITION_UNSET, GomokuStonePosition.POSITION_UNSET);
        }
        return null;
    }

    @Override
    public boolean canUse(StoneType type) {
        Integer quantity = getStocks().getOrDefault(type, 0);
        return quantity == UNLIMITED || quantity > 0;

    }

    private void reduce(StoneType type) {
        getStocks().entrySet().stream()
                .filter(set -> set.getKey().equals(type.type()) && (set.getValue() != UNLIMITED) && (set.getValue() > 0))
                .forEach(set -> set.setValue(set.getValue() - 1));
    }

}
