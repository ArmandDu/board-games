package com.github.armanddu.boardgames.gomoku.stone;

import com.github.armanddu.boardgames.lib.stone.Stone;
import com.github.armanddu.boardgames.lib.stone.DefaultStoneNodeChild;

import java.util.List;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class GomokuStoneNodeChild extends DefaultStoneNodeChild {

    public GomokuStoneNodeChild(List<Stone> child, int weight, int surrounds) {
        super(weight, surrounds, child);
    }

}
