package com.github.armanddu.boardgames.go.stone;

import com.github.armanddu.boardgames.lib.stone.Stone;

import java.util.List;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GoStoneNodeChild extends DefaultStoneNodeChild {

    public GoStoneNodeChild(List<Stone> child, int weight, int surrounds) {
        super(weight, surrounds, child);
    }

}
