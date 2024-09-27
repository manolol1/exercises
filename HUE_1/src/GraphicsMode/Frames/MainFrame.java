package GraphicsMode.Frames;

import General.*;
import GraphicsMode.AutoPlayThread;
import GraphicsMode.BoardCanvas;
import GraphicsMode.CustomComponents.MyButton;
import GraphicsMode.CustomComponents.MySlider;
import GraphicsMode.Frames.NewBoardFrames.NewBoardModeSelectionFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;

public class MainFrame extends JFrame {
    private Board board;

    private int autoDelay = 1000; // ms
    private boolean autoPlay;
    private final AutoPlayThread autoPlayThread;

    private ImageIcon frameIcon, playIcon, pauseIcon;

    private final BoardCanvas boardCanvas;

    public MainFrame() {
        // set up app directory and files
        try {
            FileManager.setup(true);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,  Constants.FILE_SETUP_ERROR_MESSAGE + e.getMessage(),
                    "Error while setting up application files", JOptionPane.ERROR_MESSAGE);
        }

        /* set up icons */
        frameIcon = new ImageIcon("resources/images/seedling-solid.png");
        playIcon = new ImageIcon("resources/images/play-solid.png");
        pauseIcon = new ImageIcon("resources/images/pause-solid.png");

        playIcon = Utils.resizeIcon(playIcon, 30, 36);
        pauseIcon = Utils.resizeIcon(pauseIcon, 30, 36);

        /* set up JFrame */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(Constants.DEFAULT_MAIN_FRAME_SIZE);
        this.setMinimumSize(new Dimension(800, 600));
        this.setTitle("Game of Life");
        this.setLocationRelativeTo(null); // center window on screen
        this.setIconImage(frameIcon.getImage());

        /* set up default board */
        board = BoardFactory.getRandom(100, 150, 20);

        /* Board Canvas */
        boardCanvas = new BoardCanvas(board);

        /* set up autoPlay thread */
        autoPlayThread = new AutoPlayThread(autoDelay, boardCanvas, board);
        autoPlayThread.start();

        /* Options Panel */
        JPanel optionsPanel = new JPanel();
        optionsPanel.setPreferredSize(new Dimension(170, 0));
        optionsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        optionsPanel.setBackground(Constants.COLOR_BACKGROUND_1);

        // new board button
        MyButton newBoardButton = new MyButton("New Board");
        newBoardButton.setPreferredSize(new Dimension(150, 40));
        newBoardButton.addActionListener(e -> {
            new NewBoardModeSelectionFrame(this);
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
        controlsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 7));

        MyButton nextGenerationButton = new MyButton("Next Generation");
        nextGenerationButton.setPreferredSize(new Dimension(200, 40));
        nextGenerationButton.addActionListener(e -> {
            board.simulate();
            boardCanvas.repaint();
        });
        controlsPanel.add(nextGenerationButton);

        MyButton playButton = new MyButton(playIcon);
        playButton.setPreferredSize(new Dimension(40, 40));
        playButton.addActionListener(e -> {
            if (autoPlay) {
                playButton.setIcon(playIcon);
                autoPlay = false;
                autoPlayThread.pauseThread();
            } else {
                playButton.setIcon(pauseIcon);
                autoPlay = true;
                autoPlayThread.resumeThread();
            }
        });
        controlsPanel.add(playButton);

        JPanel delayPanel = new JPanel(new FlowLayout());
        delayPanel.setBackground(Constants.COLOR_BACKGROUND_2);

        JLabel delayLabel = new JLabel("Simulation Delay:   ");
        delayLabel.setForeground(Constants.COLOR_FOREGROUND);
        delayLabel.setFont(delayLabel.getFont().deriveFont((float) 16));

        JLabel delayValueLabel = new JLabel("   " + autoDelay);
        delayValueLabel.setForeground(Constants.COLOR_FOREGROUND);
        delayValueLabel.setFont(delayValueLabel.getFont().deriveFont((float) 16));

        MySlider delaySlider = new MySlider(100, 3000, 1000);
        delaySlider.setPreferredSize(new Dimension(270, 30));
        delaySlider.addChangeListener(e -> {
            autoDelay = delaySlider.getValue();
            autoPlayThread.setDelay(autoDelay);
            delayValueLabel.setText(("   " + autoDelay));
        });

        delayPanel.add(delayLabel);
        delayPanel.add(delaySlider);
        delayPanel.add(delayValueLabel);
        controlsPanel.add(delayPanel);

        // Add every panel to the frame
        this.add(optionsPanel, BorderLayout.WEST);
        this.add(controlsPanel, BorderLayout.SOUTH);
        this.add(boardCanvas, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void setBoard(Board board) {
        this.board = board;
        boardCanvas.setBoard(board);
        autoPlayThread.setBoard(board);
    }
}
