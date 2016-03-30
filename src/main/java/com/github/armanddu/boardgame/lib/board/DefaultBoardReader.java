package com.github.armanddu.boardgame.lib.board;

import com.github.armanddu.boardgame.gomoku.stone.GomokuStone;
import com.github.armanddu.boardgame.gomoku.stone.GomokuStoneMove;
import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

import java.util.Collections;
import java.util.List;

/**
 * Created by armanddu on 30/03/16 for board-games.
 */
public class DefaultBoardReader implements BoardReader {
    protected final Board board;

    public DefaultBoardReader(Board board) {
        this.board = board;
    }

    public final Stone get(int x, int y) {
        return this.board.get(x, y);
    }

    public int getWidth() {
        return this.board.getWidth();
    }

    public int getHeight() {
        return this.board.getHeight();
    }

    public boolean isValidMove(StoneMove stoneMove) {
        return board.isValidMove(stoneMove);
    }

    @Override
    public int getScore(StoneColor color) {
        return board.getScore(color);
    }

    @Override
    public final List<Stone> getStones() {
        return Collections.unmodifiableList(board.getStones());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int width = this.getWidth();
        int height = this.getHeight();
        drawInfo(builder, width, height);
        drawXAxis(builder, height);

        for (int i = 0; i < width; i++) {
            drawLine(builder, height);

            drawYAxis(builder, i);
            for (int j = 0; j < height; j++) {
                Stone stone = this.get(j, i);
                builder.append("| ").append(stone != null ? stone.getColor().toString().charAt(0) : getFreeCaseString(j, i))
                        .append(" ");
            }
            builder.append("|\n");
        }
        drawLine(builder, height);

        return builder.toString();
    }

    private String getFreeCaseString(int x, int y) {
        GomokuStoneMove white = new GomokuStoneMove(new GomokuStone(StoneColor.WHITE, 0, 0), x, y);
        GomokuStoneMove black = new GomokuStoneMove(new GomokuStone(StoneColor.BLACK, 0, 0), x, y);
        int v = isValidMove(white) ? 1 : 0;
        v += isValidMove(black) ? 10 : 0;
        return v == 11 ? "_" : v == 10 ? "b" : v == 1 ? "w" : " ";
    }

    private void drawYAxis(StringBuilder builder, int y) {
        builder.append(y < 10 ? "  " : " ").append(y).append(" ");
    }

    private void drawLine(StringBuilder builder, int height) {
        builder.append("    .");
        for (int j = 0; j < height; j++) {
            builder.append("---.");
        }
        builder.append("\n");
    }

    private void drawXAxis(StringBuilder builder, int height) {
        builder.append(" y\\x ");
        for (int x = 0; x < height; x++) {
            builder.append(x >= 10 ? "" : " ").append(x).append("  ");
        }
        builder.append("\n");
    }

    private void drawInfo(StringBuilder builder, int width, int height) {
        builder.append(this.getClass().getSimpleName()).append(" ").append(width).append(":").append(height)
                .append("\n");
    }
}
