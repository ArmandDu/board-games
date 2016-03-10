package org.github.armanddu.boardgame.gomoku.stone;

import java.util.Arrays;
import java.util.List;

import org.github.armanddu.boardgame.stone.Stone;
import org.github.armanddu.boardgame.stone.StoneType;

public class GomokuStone implements Stone {

  private StoneType type;
  private int y;
  private int x;
  private StoneNode verticalNodes;
  private StoneNode horizontalNodes;
  private StoneNode diagonalLeftNodes;
  private StoneNode diagonalRightNodes;


  public GomokuStone(StoneType type, int x, int y) {
    this.type = type;
    this.x = x;
    this.y = y;
    this.verticalNodes = new GomokuStoneNode();
    this.horizontalNodes = new GomokuStoneNode();
    this.diagonalLeftNodes = new GomokuStoneNode();
    this.diagonalRightNodes = new GomokuStoneNode();
  }

  public StoneType getType() {
    return type;
  }

  public StoneNode getMaxWeight() {
    StoneNode[] stones = {this.horizontalNodes, this.diagonalLeftNodes, this.diagonalRightNodes};
    StoneNode max = this.verticalNodes;
    for (StoneNode stone : stones) {
      if (stone.size() >= max.size()) {
        max = stone;
      }
    }
    return max;
  }

  public void computeWeight(Stone[][] board) {
    this.findVerticalNodes(board);
    this.findHorizontalNodes(board);
    this.findDiagonalLeftNodes(board);
    this.findDiagonalRightNodes(board);

  }

  private void findDiagonalRightNodes(Stone[][] board) {
    findNodes(board, this.diagonalRightNodes, 1, -1);
  }

  private void findDiagonalLeftNodes(Stone[][] board) {
    findNodes(board, this.diagonalLeftNodes, -1, -1);
  }

  private void findHorizontalNodes(Stone[][] board) {
    findNodes(board, this.horizontalNodes, 1, 0);
  }

  private void findVerticalNodes(Stone[][] board) {
    findNodes(board, this.verticalNodes, 0, 1);
  }

  private void findNodes(Stone[][] board, StoneNode nodes, int dx, int dy) {
    nodes.reset();
    nodes.add(this);
    int i = this.x + dx;
    int j = this.y + dy;
    while (isInBoundaray(board, i, j) && isSameType(board, i, j)) {
      nodes.add(board[i][j]);
      i += dx;
      j += dy;
    }
    int i0 = i;
    int j0 = j;
    i = this.x + -dx;
    j = this.y + -dy;
    while (isInBoundaray(board, i, j) && isSameType(board, i, j)) {
      nodes.add(board[i][j]);
      i += -dx;
      j += -dy;
    }
    setThreat(board, nodes, i0, j0);
    setThreat(board, nodes, i, j);
  }

  private void setThreat(Stone[][] board, StoneNode nodes, int i, int j) {
    if (isThreatable(nodes, board, i, j)) {
      nodes.setThreat(!nodes.isThreatened());
    }
  }

  private boolean isThreatable(StoneNode nodes, Stone[][] board, int i, int j) {
    return isInBoundaray(board, i, j) && isDifferentType(board, i, j) && nodes.size() == 2;
  }

  private boolean isDifferentType(Stone[][] board, int i, int j) {
    return board[i][j] != null && board[i][j].getType() != this.type;
  }

  private boolean isSameType(Stone[][] board, int i, int j) {
    return board[i][j] != null && board[i][j].getType() == this.type;
  }

  private boolean isInBoundaray(Stone[][] board, int i, int j) {
    return i >= 0 && j >= 0 && i < board.length && j < board[i].length;
  }

  public List<StoneNode> getNodes() {
    StoneNode[] array =
        {this.verticalNodes, this.horizontalNodes, this.diagonalLeftNodes, this.diagonalRightNodes};
    return Arrays.asList(array);
  }

  public int getY() {
    return this.y;
  }

  public int getX() {
    return this.x;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();

    builder.append("Stone: ").append(this.type).append("[").append(this.x).append(":")
        .append(this.y).append("]");
    return builder.toString();
  }

}
