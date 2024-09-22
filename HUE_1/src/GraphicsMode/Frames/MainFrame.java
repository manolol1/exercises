package GraphicsMode.Frames;

import General.Constants;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.DEFAULT_MAIN_FRAME_SIZE);
        this.setTitle("Conway's Game of Life");
        this.setVisible(true);
    }
}
