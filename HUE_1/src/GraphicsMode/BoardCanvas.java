package GraphicsMode;

import General.Board;

import javax.swing.*;
import java.awt.*;

public class BoardCanvas  extends JPanel {
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

        int fieldSize;

        {   int fieldSizeX = panelWidth / boardColumns;
            int fieldSizeY = panelHeight / boardRows;

            fieldSize = (fieldSizeX < fieldSizeY) ? fieldSizeX : fieldSizeY;
        }

        int borderX = (panelWidth - fieldSize*boardColumns) / 2;
        int borderY = (panelHeight - fieldSize*boardRows) / 2;

//        if (panelWidth < panelHeight) {
//            fieldSize = panelWidth / boardColumns;
//        } else {
//            fieldSize = panelHeight / boardRows;
//        }
//
//        int boardWidth = fieldSize * boardColumns;
//        int boardHeight = fieldSize * boardRows;
//
//        int scalingFactor = 0;
//
//        // calculate scaling factor
//        if (boardWidth > panelWidth) {
//            scalingFactor = boardWidth - panelWidth;
//        } else if (boardHeight > panelHeight) {
//            scalingFactor = boardHeight - panelHeight;
//        }
//
//        System.out.println("\n\n");
//
//        System.out.println("Panel Width: " + panelWidth);
//        System.out.println("Panel Height: " + panelHeight);
//        System.out.println();
//        System.out.println("Board Width: " + boardWidth);
//        System.out.println("Board Height: " + boardHeight);
//        System.out.println("Scaling factor: " + scalingFactor);
//        System.out.println("Field size: " + fieldSize);
//
//        // apply scaling factor
//        boardWidth -= scalingFactor;
//        boardHeight -= scalingFactor;
//
//        // recalculate fieldSize
//        fieldSize = Math.min(boardWidth / boardColumns, boardHeight / boardRows);
//
//        System.out.println("Board Width: " + boardWidth);
//        System.out.println("Board Height: " + boardHeight);
//        System.out.println("Field size: " + fieldSize);

        g2d.setPaint(Color.black);

        g2d.fillRect(borderX, borderY, boardColumns * fieldSize, boardRows * fieldSize); // draw board background

        g2d.setPaint(Color.white);

        // draw alive cells
        for (int row = 0; row < boardRows; row++) {
            for (int column = 0; column < boardColumns; column++) {
                if (boardMatrix[row][column]) {
                    g2d.fillRect(column * fieldSize + borderX, row * fieldSize + borderY, fieldSize, fieldSize);
                }
            }
        }
    }
}
