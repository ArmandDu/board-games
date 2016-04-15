package com.github.armanddu.boardgames.lib.stone;

import java.util.*;

/**
 * Created by armanddu on 31/03/16 for board-games.
 */
public abstract class AbstractStonePack implements StonePack {
    protected static final int UNLIMITED = -1;
    private final StoneColor color;
    private final Map<String, Integer> stocks;

    protected AbstractStonePack(StoneColor color)
    {
        this.color = color;
        this.stocks = new HashMap<>();

    }
    public abstract Stone getStone(StoneType type);

    public StoneColor getColor() {
        return this.color;
    }

    public List<String> getTypes() {
        return Collections.unmodifiableList(new ArrayList<>(this.stocks.keySet()));
    }

    public int getRemaining(StoneType type) {
        Integer quantity = stocks.getOrDefault(type, 0);
        return quantity == UNLIMITED ? 999_999  : quantity;
    }

    public abstract boolean canUse(StoneType type);

    protected Map<String, Integer> getStocks() {
        return stocks;
    }
}
