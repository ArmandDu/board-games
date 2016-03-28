package com.github.armanddu.boardgame.lib.stone;

import java.util.List;
import java.util.Map;

public interface StoneNode {

  List<List<Stone>> getThreats();

  List<List<Stone>> geCaptures();

  Map<String,List<Stone>> getAll();

  boolean hasWeight(int i);
}
