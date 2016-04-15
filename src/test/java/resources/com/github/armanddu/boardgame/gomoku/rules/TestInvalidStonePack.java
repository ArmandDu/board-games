package resources.com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgames.lib.stone.Stone;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import com.github.armanddu.boardgames.lib.stone.StonePack;
import com.github.armanddu.boardgames.lib.stone.StoneType;
import resources.com.github.armanddu.boardgame.stone.TestKingStone;
import resources.com.github.armanddu.boardgame.stone.TestPawnStone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by armanddu on 28/03/16 for board-games.
 */
public class TestInvalidStonePack implements StonePack {

    private List<String> list;
    private StoneColor color;

    public TestInvalidStonePack(StoneColor color) {
        this.color = color;
        list = new ArrayList<> ();
        list.add(new TestKingStone().type());
        list.add(new TestPawnStone().type());
    }

    @Override
    public StoneColor getColor() {
        return color;
    }

    @Override
    public List<String> getTypes() {
        return list;
    }

    @Override
    public boolean canUse(StoneType type) {
        return false;
    }

    @Override
    public Stone getStone(StoneType type) {
        return null;
    }

    @Override
    public int getRemaining(StoneType type) {
        return 0;
    }
}
