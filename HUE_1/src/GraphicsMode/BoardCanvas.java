package GraphicsMode;

import General.Board;

import javax.swing.*;
import java.awt.*;

public class BoardCanvas  extends JPanel {
    boolean debug = false;

    private Board board;

    public BoardCanvas(Board initialBoard) {
        this.board = initialBoard;

        this.setBackground(Color.DARK_GRAY);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // draw panel (background)
        Graphics2D g2d = (Graphics2D) g;

        boolean[][] boardMatrix = board.getMatrix();

        int boardRows = board.getRows();
        int boardColumns = board.getColumns();
        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();

        // calculate cell size
        int cellSizeX = panelWidth / boardColumns;
        int cellSizeY = panelHeight / boardRows;
        int cellSize = Math.min(cellSizeX, cellSizeY);

        // calculate borders
        int borderX = (panelWidth - cellSize * boardColumns) / 2;
        int borderY = (panelHeight - cellSize * boardRows) / 2;

        // draw board background
        g2d.setPaint(Color.black);
        g2d.fillRect(borderX, borderY, boardColumns * cellSize, boardRows * cellSize);

        if (debug) {
            System.out.println("\n [DEBUG] Board Redraw");
            System.out.println("Panel width: " + this.getWidth());
            System.out.println("Panel height: " + this.getHeight());
            System.out.println("Cell size: " + cellSize);
        }
        // draw alive cells
        g2d.setPaint(Color.white);
        for (int row = 0; row < boardRows; row++) {
            for (int column = 0; column < boardColumns; column++) {
                if (boardMatrix[row][column]) {
                    g2d.fillRect(column * cellSize + borderX, row * cellSize + borderY, cellSize, cellSize);
                }
            }
        }
    }
}
