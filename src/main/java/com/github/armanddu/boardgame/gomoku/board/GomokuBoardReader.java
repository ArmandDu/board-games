package com.github.armanddu.boardgame.gomoku.board;

import com.github.armanddu.boardgame.lib.board.Board;
import com.github.armanddu.boardgame.lib.board.BoardReader;
import com.github.armanddu.boardgame.lib.stone.Stone;
import com.github.armanddu.boardgame.lib.stone.StoneColor;
import com.github.armanddu.boardgame.lib.stone.StoneMove;

public class GomokuBoardReader implements BoardReader {

    private final Board board;


    public GomokuBoardReader(Board board) {
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
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int width = this.getWidth();
        int height = this.getHeight();
        drawInfo(builder, width, height);
        drawXAxis(builder, height);

        for (int i = 0; i < width; i++) {
            drawLine(builder, height);

            drawYaxis(builder, i);
            for (int j = 0; j < height; j++) {
                Stone stone = this.get(j, i);
                builder.append("| ").append(stone != null ? stone.getColor().toString().charAt(0) : "_")
                        .append(" ");
            }
            builder.append("|\n");
        }
        drawLine(builder, height);

        return builder.toString();
    }

    private void drawYaxis(StringBuilder builder, int i) {
        builder.append(i < 10 ? "  " : " ").append(i).append(" ");
    }

    private void drawLine(StringBuilder builder, int height) {
        builder.append("    .");
        for (int j = 0; j < height; j++) {
            builder.append("---.");
        }
        builder.append("\n");
    }

    private void drawXAxis(StringBuilder builder, int width) {
        builder.append(" y\\x ");
        for (int i = 0; i < width; i++) {
            builder.append(i >= 10 ? "" : " ").append(i).append("  ");
        }
        builder.append("\n");
    }

    private void drawInfo(StringBuilder builder, int width, int height) {
        builder.append(this.getClass().getSimpleName()).append(" ").append(width).append(":").append(height)
                .append("\n");
    }

}
