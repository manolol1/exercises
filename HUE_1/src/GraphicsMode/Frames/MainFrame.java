package GraphicsMode.Frames;

import General.Constants;
import GraphicsMode.BoardCanvas;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final JPanel optionsPanel;
    private final JPanel controlsPanel;

    private final JButton newBoardButton;
    private final JButton exitButton;

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.DEFAULT_MAIN_FRAME_SIZE);
        this.setMinimumSize(new Dimension(600, 400));
        this.setTitle("Game of Life");

        /* Options Panel */
        optionsPanel = new JPanel();
        optionsPanel.setPreferredSize(new Dimension(120, 0));
        optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        optionsPanel.setBackground(Color.BLUE);

        // new board button
        newBoardButton = new JButton("New Board");
        newBoardButton.setPreferredSize(new Dimension(100, 30));
        newBoardButton.setFocusable(false);
        newBoardButton.addActionListener(e -> {
            // TODO: Trigger creation of a new board
        });
        optionsPanel.add(newBoardButton);

        // exit button
        exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(100, 30));
        exitButton.setFocusable(false);
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
        optionsPanel.add(exitButton);

        /* Controls Panel */
        controlsPanel = new JPanel();
        controlsPanel.setPreferredSize(new Dimension(0, 80));
        controlsPanel.setBackground(Color.YELLOW);

        /* Board Canvas */
        BoardCanvas boardCanvas = new BoardCanvas();

        // Add every panel to the frame
        this.add(optionsPanel, BorderLayout.WEST);
        this.add(controlsPanel, BorderLayout.SOUTH);
        this.add(boardCanvas, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
