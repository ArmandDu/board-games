package com.github.armanddu.boardgame.gomoku.stone;

import java.util.*;

import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneNode;
import com.github.armanddu.boardgame.lib.stone.StoneNodeChild;

public class GomokuStoneNode implements StoneNode{

    public static final String HORIZONTAL_CHILD = "Horizontal";
    public static final String VERTICAL_CHILD = "Vertical";
    public static final String DIAGONAL_RIGHT_CHILD = "DiagonalRight";
    public static final String DIAGONAL_LEFT_CHILD = "DiagonalLeft";
    private final BoardReader map;
    private final Stone center;
    private final Map<String, List<Stone>> children;
    private final Map<String, Integer> surrounds;
    private final List<List<Stone>> threats;
    private final List<List<Stone>> captures;
    private int weight;

    public GomokuStoneNode(BoardReader map, Stone center) {
        this.map = map;
        this.center = center;
        this.weight = 0;
        this.threats = new ArrayList<>();
        this.captures = new ArrayList<>();
        this.children = new HashMap<>();
        surrounds = new HashMap<>();
        this.children.put(HORIZONTAL_CHILD, new ArrayList<>());
        this.children.put(VERTICAL_CHILD, new ArrayList<>());
        this.children.put(DIAGONAL_RIGHT_CHILD, new ArrayList<>());
        this.children.put(DIAGONAL_LEFT_CHILD, new ArrayList<>());
        this.surrounds.put(HORIZONTAL_CHILD, 0);
        this.surrounds.put(VERTICAL_CHILD, 0);
        this.surrounds.put(DIAGONAL_RIGHT_CHILD, 0);
        this.surrounds.put(DIAGONAL_LEFT_CHILD, 0);
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
            this.weight = nodes.size() + 1;
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
            List<List<Stone>> toAdd = surrounded == 1 ? this.threats : this.captures;
            toAdd.add(node);
        }
    }

    private boolean isThread(StoneColor color, int x, int y) {
        Stone stone = map.get(x, y);
        return (stone != null) && (stone.getColor() != color);
    }


    @Override
    public List<List<Stone>> getThreats() {
        return this.threats;
    }

    @Override
    public List<List<Stone>> geCaptures() {
        return this.captures;
    }

    @Override
    public Map<String, StoneNodeChild> getChildren() {
        Map<String, StoneNodeChild> result = new HashMap<>();
        this.children.entrySet().stream()
                .forEach(child -> result.put(child.getKey(), createChildNode(child)));
        return result;
    }

    private GomokuStoneNodeChild createChildNode(Map.Entry<String, List<Stone>> child) {
        return new GomokuStoneNodeChild(child.getValue(), surrounds.getOrDefault(child.getKey(), 0));
    }

    @Override
    public boolean hasWeight(int weight) {
        boolean valid = false;
        for (String key: children.keySet()) {
            valid = valid || getWeight(children.get(key)) == weight;
        }
        return valid;
    }

    private int getWeight(List<Stone> node) {
        return node.size() + 1;
    }

}
