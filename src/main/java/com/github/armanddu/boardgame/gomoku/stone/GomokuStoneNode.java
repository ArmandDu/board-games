package com.github.armanddu.boardgame.gomoku.stone;

import java.util.*;

import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneColor;
import com.github.armanddu.boardgame.stone.StoneNode;

public class GomokuStoneNode implements StoneNode{

    private BoardReader map;
    private Stone center;
    private Map<String, List<Stone>> childs;
    private int weight;
    private List<List<Stone>> threats;
    private List<List<Stone>> captures;

    public GomokuStoneNode(BoardReader map, Stone center) {
        this.map = map;
        this.center = center;
        this.weight = 0;
        this.threats = new ArrayList<>();
        this.captures = new ArrayList<>();
        this.childs = new HashMap<>();
        this.childs.put("Horizontal", new ArrayList<>());
        this.childs.put("Vertical", new ArrayList<>());
        this.childs.put("DiagonalRight", new ArrayList<>());
        this.childs.put("DiagonalLeft", new ArrayList<>());
        compute();
    }

    private void compute() {
        compute(this.childs.get("Horizontal"), 1, 0);
        compute(this.childs.get("Vertical"), 0, 1);
        compute(this.childs.get("DiagonalRight"), 1, 1);
        compute(this.childs.get("DiagonalLeft"), -1, 1);
    }

    private void compute(List<Stone> nodes, int dx, int dy) {
        int surrounded = 0;
        nodes.clear();
        //nodes.add(center);
        int x = center.getX() + dx;
        int y = center.getY() + dy;
        StoneColor color = center.getColor();
        while (map.get(x, y) != null && map.get(x, y).getColor() == color) {
            Stone stone = map.get(x, y);
            nodes.add(stone);
            x += dx;
            y += dy;
        }
        surrounded += (isThread(color, x, y) ? 1 : 0);
        x = center.getX() + -dx;
        y = center.getY() + -dy;
        while (map.get(x, y) != null && map.get(x, y).getColor() == color) {
            Stone stone = map.get(x, y);
            nodes.add(stone);
            x += -dx;
            y += -dy;
        }
        surrounded += (isThread(color, x, y) ? 1 : 0);
        threatOrCaptured(nodes, surrounded);
        if (nodes.size() > this.weight) {
            this.weight = nodes.size() + 1;
        }
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
    public Map<String, List<Stone>> getAll() {
        return this.childs;
    }

    @Override
    public boolean hasWeight(int weight) {
        Map<String, List<Stone>> all =  this.getAll();
        boolean valid = false;
        for (String key: all.keySet()) {
            valid = valid || getWeight(all.get(key)) == weight;
        }
        return valid;
    }

    private int getWeight(List<Stone> node) {
        return node.size() + 1;
    }

}
