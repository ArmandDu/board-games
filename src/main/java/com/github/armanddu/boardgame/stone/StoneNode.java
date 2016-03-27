package com.github.armanddu.boardgame.stone;

import java.util.Collection;
import java.util.List;

import com.github.armanddu.boardgame.stone.Stone;

public interface StoneNode {

  List<List<Stone>> getAll();

  int getWeight();

}
