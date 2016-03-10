package org.github.armanddu.boardgame.rule;

import java.util.List;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.board.BoardDimension;
import org.github.armanddu.boardgame.board.Capture;
import org.github.armanddu.boardgame.stone.StoneType;

public interface Rule {

  boolean isEnoughPlayers(int size);

  String getPlayersRules();

  String getReadableRules();

  BoardDimension getBoardSize();

  boolean isWinningSet(Board board);

  boolean isFiveInaRow(Board board);

  boolean isFiveInaRowUnbreakable(Board board);

  StoneType getWinningStoneType(Board board);

  void setWinningStoneType(StoneType stone);

  void update(Board board);

  void setIsFiveInARow(boolean isFiveInARow);

  void setIsFiveInARowUnbreakable(boolean isFiveInARowUnbreakable);

  boolean isValidMove(Board board, StoneType stone, int x, int y);

  List<Capture> getCaptures();

  void setCaptures(List<Capture> captures);


}
