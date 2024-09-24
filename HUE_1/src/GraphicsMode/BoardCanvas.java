package GraphicsMode;

import javax.swing.*;
import java.awt.*;

public class BoardCanvas  extends JPanel {
    public BoardCanvas() {
        this.setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // draw panel (background)
        Graphics2D g2d = (Graphics2D) g;

        g2d.setPaint(Color.white);

        g2d.drawLine(0, 0, this.getWidth(), this.getHeight());
    }

    public void redraw() {
        this.repaint();
    }
}
