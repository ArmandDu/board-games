package com.github.armanddu.boardgames.go.stone;

import com.github.armanddu.boardgames.lib.stone.Stone;

import java.util.Collections;
import java.util.List;

/**
 * Created by armanddu on 31/03/16 for board-games.
 */
public class DefaultStoneNodeChild implements StoneNodeChild {
    protected final List<Stone> child;
    private final int surrounds;
    private final int weight;

    public DefaultStoneNodeChild(int weight, int surrounds, List<Stone> child) {
        this.weight = weight;
        this.surrounds = surrounds;
        this.child = child;
    }

    @Override
    public int getWeight() {
        return child.isEmpty() ? 0 : weight;
    }

    @Override
    public List<Stone> getStones() {
        return Collections.unmodifiableList(child);
    }

    @Override
    public boolean isFree() {
        return surrounds == 0;
    }
}
