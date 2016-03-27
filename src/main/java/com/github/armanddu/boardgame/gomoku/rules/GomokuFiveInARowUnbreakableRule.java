package com.github.armanddu.boardgame.gomoku.rules;

import com.github.armanddu.boardgame.gomoku.stone.GomokuStone;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStoneNode;
import com.github.armanddu.boardgame.stone.StoneNode;
import com.github.armanddu.boardgame.map.BoardReader;
import com.github.armanddu.boardgame.rule.EndGameRule;
import com.github.armanddu.boardgame.stone.StoneMove;
import com.github.armanddu.boardgame.stone.StonePosition;

public class GomokuFiveInARowUnbreakableRule implements EndGameRule {

  @Override
  public String asString() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isValid(BoardReader map, StoneMove stoneMove) {
    StonePosition position = stoneMove.getSuggestedPosition();
    GomokuStone center = new GomokuStone(stoneMove.getColor(), position.getX(), position.getY());
    StoneNode node = new GomokuStoneNode(map, center);
    return node.getWeight() == 5;
  }

}
