package com.github.armanddu.boardgame.gomoku.stone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.stone.Stone;
import com.github.armanddu.boardgame.stone.StoneNode;

public class GomokuStoneNode implements StoneNode {

  private BoardReader map;
  private Stone center;
  private Map<String, List<Stone>> childs;
  private int weight;

  public GomokuStoneNode(BoardReader map, Stone center) {
    this.map = map;
    this.center = center;
    this.childs = new HashMap<String, List<Stone>>();
    this.childs.put("Horizontal", new ArrayList<Stone>());
    this.childs.put("Vertical", new ArrayList<Stone>());
    this.childs.put("DiagonalRight", new ArrayList<Stone>());
    this.childs.put("DiagonalLeft", new ArrayList<Stone>());
    compute();
  }

  private void compute() {
    compute(this.childs.get("Horizontal"), 1, 0);
    compute(this.childs.get("Vertical"), 0, 1);
    compute(this.childs.get("DiagonalRight"), 1, 1);
    compute(this.childs.get("DiagonalLeft"), -1, 1);
  }

  private void compute(List<Stone> nodes, int dx, int dy) {
    nodes.clear();
    nodes.add(center);
    int x = center.getX() + dx;
    int y = center.getY() + dy;
    while (map.get(x, y) != null && map.get(x, y).getColor() == center.getColor()) {
      Stone stone = map.get(x, y);
      nodes.add(stone);
      x += dx;
      y += dy;
    }
    x = center.getX() + -dx;
    y = center.getY() + -dy;
    while (map.get(x, y) != null && map.get(x, y).getColor() == center.getColor()) {
      Stone stone = map.get(x, y);
      nodes.add(stone);
      x += -dx;
      y += -dy;
    }
    if (nodes.size() > this.weight) {
      this.weight = nodes.size();
    }
  }

  @Override
  public List<List<Stone>> getAll() {
    return new ArrayList<List<Stone>>(childs.values());
  }

  @Override
  public int getWeight() {
    return this.weight;
  }

}
