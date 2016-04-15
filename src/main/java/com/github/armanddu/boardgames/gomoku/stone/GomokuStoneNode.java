package com.github.armanddu.boardgames.gomoku.stone;

import java.util.*;

import com.github.armanddu.boardgames.lib.board.BoardReader;
import com.github.armanddu.boardgames.lib.stone.*;

public class GomokuStoneNode extends AbstractStoneNode {

    private final BoardReader map;
    private final Stone center;
    private int weight;

    public GomokuStoneNode(BoardReader map, Stone center) {
        super();
        this.map = map;
        this.center = center;
        this.weight = 0;
        compute();
    }

    private void compute() {
        compute(HORIZONTAL_CHILD, 1, 0);
        compute(VERTICAL_CHILD, 0, 1);
        compute(DIAGONAL_RIGHT_CHILD, 1, 1);
        compute(DIAGONAL_LEFT_CHILD, -1, 1);
    }

    /** compute function
     * add to a given string an direction all stones aligned with 'center'
     * used to add center to the given list but to avoid duplication, removed it and now use getWeight()
     * to get node list size + 1 (for the center one)
     */
    private void compute(String name, int dx, int dy) {
        List<Stone> nodes = children.get(name);
        nodes.clear();
        //nodes.add(center);
        StoneColor color = center.getColor();
        int surrounded = 0;
        surrounded += addChildren(nodes, dx, dy, color);
        surrounded += addChildren(nodes, -dx, -dy, color);
        surrounds.put(name, surrounded);
        threatOrCaptured(nodes, surrounded);
        if (nodes.size() > this.weight) {
            this.weight = getWeight(nodes);
        }
    }

    private int addChildren(List<Stone> nodes, int dx, int dy, StoneColor color) {
        int x = center.getX() + dx;
        int y = center.getY() + dy;
        while (map.get(x, y) != null && map.get(x, y).getColor() == color) {
            Stone stone = map.get(x, y);
            nodes.add(stone);
            x += dx;
            y += dy;
        }
        return  getSurrounded(x, y, color);
    }

    private int getSurrounded(int x, int y, StoneColor color) {
        return  (isThread(color, x, y) ? 1 : 0);
    }

    private void threatOrCaptured(List<Stone> node, int surrounded) {
        if (getWeight(node) == 2 && surrounded != 0) {
            selectList(surrounded).add(node);
        }
    }

    private List<List<Stone>> selectList(int surrounded) {
        return surrounded == 1 ? this.threats : this.captures;
    }

    private boolean isThread(StoneColor color, int x, int y) {
        Stone stone = map.get(x, y);
        return (stone != null) && stone.getColor() != color;
    }

    protected int getWeight(List<Stone> node) {
        return node.size() + (node.contains(center) ? 0 : 1);
    }


}
