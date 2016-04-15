package com.github.armanddu.boardgames.go.stone;

import com.github.armanddu.boardgames.go.stone.StoneNodeChild;
import com.github.armanddu.boardgames.lib.stone.Stone;

import java.util.List;
import java.util.Map;

public interface StoneNode {

  List<List<Stone>> getThreats();

  List<List<Stone>> geCaptures();

  Map<String, StoneNodeChild> getChildren();

  boolean hasWeight(int i);
}
