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

        int panelWidth = this.getWidth();
        int panelHeight = this.getHeight();

        g2d.setPaint(Color.white);

        int boardWidth =
    }
}
