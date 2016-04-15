package com.github.armanddu.boardgames.gomoku.stone;

import static org.junit.Assert.*;

import com.github.armanddu.boardgames.lib.stone.StoneStatus;
import org.junit.Test;

import com.github.armanddu.boardgames.lib.player.Player;
import com.github.armanddu.boardgames.lib.stone.Stone;
import com.github.armanddu.boardgames.lib.stone.StoneColor;
import resources.com.github.armanddu.boardgame.gomoku.player.TestGomokuPlayer;
import resources.com.github.armanddu.boardgame.stone.TestStonePosition;

public class GomokuStoneTest {

    private static final String PLAYER_1 = "player 1";

    @Test
    public void test() {
        StoneColor color = StoneColor.WHITE;
        int y = 0;
        int x = 0;
        Stone stone = new GomokuStone(color, x, y);
        Player player = new TestGomokuPlayer(PLAYER_1, StoneColor.WHITE);
        stone.setOwner(player);
        assertNotNull(stone);
        assertEquals(StoneColor.WHITE, stone.getColor());
        assertEquals(GomokuStoneType.type, stone.getType().type());
        assertEquals(PLAYER_1, stone.getOwner().getName());
    }

    @Test
    public void testGetStatus() throws Exception {
        StoneColor color = StoneColor.WHITE;
        int y = 0;
        int x = 0;
        Stone stone = new GomokuStone(color, x, y);
        Player player = new TestGomokuPlayer(PLAYER_1, StoneColor.WHITE);
        stone.setOwner(player);

        StoneStatus status = stone.getStatus();
    }

    @Test
    public void testGetMovesHistory() throws Exception {
        StoneColor color = StoneColor.WHITE;
        int y = 0;
        int x = 0;
        Stone stone = new GomokuStone(color, x, y);
        Player player = new TestGomokuPlayer(PLAYER_1, StoneColor.WHITE);
        stone.setOwner(player);

        assertTrue(stone.getMovesHistory().isEmpty());
        stone.apply(new TestStonePosition(1, 1));
        assertEquals(1, stone.getMovesHistory().size());
    }

    @Test
    public void testGetX() throws Exception {
        StoneColor color = StoneColor.WHITE;
        int y = 0;
        int x = 0;
        Stone stone = new GomokuStone(color, x, y);
        Player player = new TestGomokuPlayer(PLAYER_1, StoneColor.WHITE);
        stone.setOwner(player);

        assertEquals(x, stone.getX());
    }

    @Test
    public void testGetY() throws Exception {
        StoneColor color = StoneColor.WHITE;
        int y = 0;
        int x = 0;
        Stone stone = new GomokuStone(color, x, y);
        Player player = new TestGomokuPlayer(PLAYER_1, StoneColor.WHITE);
        stone.setOwner(player);

        assertEquals(y, stone.getY());
    }

    @Test
    public void testGetPosition() throws Exception {
        StoneColor color = StoneColor.WHITE;
        int y = 0;
        int x = 0;
        Stone stone = new GomokuStone(color, x, y);
        Player player = new TestGomokuPlayer(PLAYER_1, StoneColor.WHITE);
        stone.setOwner(player);

        assertEquals(x, stone.getPosition().getX());
        assertEquals(y, stone.getPosition().getY());
    }

    @Test
    public void testApply() throws Exception {
        StoneColor color = StoneColor.WHITE;
        int y = 0;
        int x = 0;
        Stone stone = new GomokuStone(color, x, y);
        Player player = new TestGomokuPlayer(PLAYER_1, StoneColor.WHITE);
        stone.setOwner(player);

        assertTrue(stone.getMovesHistory().isEmpty());
        stone.apply(new TestStonePosition(1, 1));
        assertEquals(1, stone.getMovesHistory().size());
        assertEquals(x, stone.getMovesHistory().get(0).getX());
        assertEquals(y, stone.getMovesHistory().get(0).getY());
    }

    @Test
    public void testToString() throws Exception {
        StoneColor color = StoneColor.WHITE;
        int y = 0;
        int x = 0;
        Stone stone = new GomokuStone(color, x, y);
        Player player = new TestGomokuPlayer(PLAYER_1, StoneColor.WHITE);
        stone.setOwner(player);

        assertNotNull(stone.toString());
    }
}
