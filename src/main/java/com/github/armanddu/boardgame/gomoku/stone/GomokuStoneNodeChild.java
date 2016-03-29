package com.github.armanddu.boardgame.gomoku.stone;

import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneNodeChild;

import java.util.List;
import java.util.Map;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuStoneNodeChild implements StoneNodeChild {

    private final List<Stone> child;
    private final int surrounds;

    public GomokuStoneNodeChild(List<Stone> child, int surrounds) {
        this.child = child;
        this.surrounds = surrounds;
    }

    @Override
    public int getWeight() {
        return child.isEmpty() ? 0 : child.size() + 1;
    }

    @Override
    public List<Stone> getStones() {
        return child;
    }

    @Override
    public boolean isFree() {
        return surrounds == 0;
    }
}
