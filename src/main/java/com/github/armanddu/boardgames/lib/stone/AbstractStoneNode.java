package com.github.armanddu.boardgames.lib.stone;

import java.util.*;

/**
 * Created by armanddu on 31/03/16 for board-games.
 */
public abstract class AbstractStoneNode implements StoneNode {
    public static final String HORIZONTAL_CHILD = "Horizontal";
    public static final String VERTICAL_CHILD = "Vertical";
    public static final String DIAGONAL_RIGHT_CHILD = "DiagonalRight";
    public static final String DIAGONAL_LEFT_CHILD = "DiagonalLeft";
    protected final Map<String, List<Stone>> children;
    protected final Map<String, Integer> surrounds;
    protected final List<List<Stone>> threats;
    protected final List<List<Stone>> captures;

    public AbstractStoneNode() {
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
    }

    @Override
    public List<List<Stone>> getThreats() {
        return Collections.unmodifiableList(this.threats);
    }

    @Override
    public List<List<Stone>> geCaptures() {
        return Collections.unmodifiableList(this.captures);
    }

    @Override
    public Map<String, StoneNodeChild> getChildren() {
        Map<String, StoneNodeChild> result = new HashMap<>();
        this.children.entrySet().stream()
                .forEach(child -> result.put(child.getKey(), createChildNode(child)));
        return Collections.unmodifiableMap(result);
    }

    private DefaultStoneNodeChild createChildNode(Map.Entry<String, List<Stone>> child) {
        List<Stone> value = child.getValue();
        return new DefaultStoneNodeChild(getWeight(value), surrounds.getOrDefault(child.getKey(), 0), value);
    }

    @Override
    public boolean hasWeight(int weight) {
        return children.values().stream().anyMatch(child -> getWeight(child) == weight);
    }

    protected abstract int getWeight(List<Stone> node);
}
