package org.github.armanddu.boardgame.gomoku.board;

import java.util.ArrayList;
import java.util.List;

import org.github.armanddu.boardgame.board.Board;
import org.github.armanddu.boardgame.board.BoardDimension;
import org.github.armanddu.boardgame.gomoku.stone.GomokuStone;
import org.github.armanddu.boardgame.stone.Stone;
import org.github.armanddu.boardgame.stone.StoneType;

public class GomokuBoard implements Board {

  private BoardDimension boardSize;
  private List<Stone> stones;
  private Stone[][] board;
  private Stone lastStone;

  public GomokuBoard(BoardDimension boardSize) {
    this.setBoardSize(boardSize);
    this.stones = new ArrayList<Stone>();
    this.lastStone = null;
    this.board = new Stone[boardSize.getWidth()][boardSize.getHeight()];
  }

  public void setStone(StoneType stoneType, int i, int j) {
    if (i >= 0 && i < this.boardSize.getWidth() && j >= 0 && j < this.boardSize.getHeight()) {
      if (this.board[i][j] == null) {
        Stone stone = new GomokuStone(stoneType, i, j);
        this.board[i][j] = stone;
        this.lastStone = stone;
        this.stones.add(stone);
      }
    }
  }

  public BoardDimension getBoardSize() {
    return boardSize;
  }

  public void setBoardSize(BoardDimension boardSize) {
    this.boardSize = boardSize;
  }

  public List<Stone> getStones() {
    return this.stones;
  }

  public Stone[][] getBoard() {
    return this.board;
  }

  public boolean isInBoundaries(int i, int j) {
    return (i >= 0 && j >= 0 && i < this.boardSize.getWidth() && j < this.boardSize.getHeight());
  }

  public Stone getLastStone() {
    return this.lastStone;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("Board: ").append(this.getBoardSize()).append("\n");
    for (int j = 0; j < board.length; j++) {
      for (int i = 0; i < board[0].length; i++) {
        builder.append("--|");
      }
      builder.append("\n");
      for (int i = 0; i < board[0].length; i++) {
        Stone stone = board[i][j];
        builder.append((stone != null ? stone.getType().toString().toCharArray()[0] : " "))
            .append(" |");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

}
