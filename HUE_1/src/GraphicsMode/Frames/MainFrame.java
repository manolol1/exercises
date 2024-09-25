package GraphicsMode.Frames;

import General.Board;
import General.BoardFactory;
import General.Constants;
import General.FileManager;
import GraphicsMode.BoardCanvas;
import GraphicsMode.CustomComponents.MyButton;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {

    public MainFrame() {
        // set up app directory and files
        try {
            FileManager.setup(true);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,  Constants.FILE_SETUP_ERROR_MESSAGE + e.getMessage(),
                    "Error while setting up application files", JOptionPane.ERROR_MESSAGE);
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.DEFAULT_MAIN_FRAME_SIZE);
        this.setMinimumSize(new Dimension(600, 400));
        this.setTitle("Game of Life");
        this.setLocationRelativeTo(null); // center window on screen

        /* set up board */
        Board board = BoardFactory.getRandom(100, 150, 20);

        /* Board Canvas */
        BoardCanvas boardCanvas = new BoardCanvas(board);

        /* Options Panel */
        JPanel optionsPanel = new JPanel();
        optionsPanel.setPreferredSize(new Dimension(170, 0));
        optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        optionsPanel.setBackground(Constants.COLOR_BACKGROUND_1);

        // new board button
        MyButton newBoardButton = new MyButton("New Board");
        newBoardButton.setPreferredSize(new Dimension(150, 40));
        newBoardButton.addActionListener(e -> {
            // TODO: Trigger creation of a new board
        });
        optionsPanel.add(newBoardButton);

        // exit button
        MyButton exitButton = new MyButton("Exit");
        exitButton.setPreferredSize(new Dimension(150, 40));
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
        optionsPanel.add(exitButton);

        /* Controls Panel */
        JPanel controlsPanel = new JPanel();
        controlsPanel.setPreferredSize(new Dimension(0, 54));
        controlsPanel.setBackground(Constants.COLOR_BACKGROUND_2);
        controlsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 7));

        MyButton nextGenerationButton = new MyButton("Next Generation");
        nextGenerationButton.setPreferredSize(new Dimension(200, 40));
        nextGenerationButton.addActionListener(e -> {
            board.simulate();
            boardCanvas.repaint();
        });
        controlsPanel.add(nextGenerationButton);

        // Add every panel to the frame
        this.add(optionsPanel, BorderLayout.WEST);
        this.add(controlsPanel, BorderLayout.SOUTH);
        this.add(boardCanvas, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
