package GraphicsMode.Frames.NewBoardFrames;

import General.*;
import GraphicsMode.BoardCanvas;
import GraphicsMode.CustomComponents.MyButton;
import GraphicsMode.CustomComponents.MyComboBox;
import GraphicsMode.Frames.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class NewBoardFromFileFrame extends JFrame {
    private Board board;
    private final MyComboBox<String> fileBox;
    ArrayList<File> files = null;

    public NewBoardFromFileFrame(MainFrame mainFrame) {

        /* set up JFrame */
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(700, 500);
        this.setResizable(false);
        this.setTitle("New Board: From file");
        this.setLocationRelativeTo(mainFrame); // center window on screen
        this.getContentPane().setBackground(Constants.COLOR_BACKGROUND_2);
        this.setLayout(new BorderLayout());

        // Info text
        String labelText = "<html>"
                + "<div style='font-size: 18px; text-align: center; margin-bottom: 10px;'>Select a Board File!</div>"
                + "<div style='font-size: 14px; text-align: center;'>Hint: Board files are stored in:</div>"
                + "<div style='font-size: 12px; text-align: center; margin-bottom: 8px;'><i>" + Constants.BOARDS_DIRECTORY + "</i></div>"
                + "<div style='font-size: 11px; text-align: center;'>Take a look at the templates there and make your own boards!</div>"
                + "</html>";
        JLabel infoLabel = new JLabel(labelText, SwingConstants.CENTER);
        infoLabel.setForeground(Constants.COLOR_FOREGROUND);

        this.add(infoLabel, BorderLayout.NORTH);

        try {
            files = FileManager.getBoardFiles();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,  Constants.FILE_READ_ERROR_MESSAGE + e.getMessage(),
                    "Error while setting up application files", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }

        ArrayList<String> fileNames = new ArrayList<>();

        for (File file : files) {
            String fileName = file.getName();
            if (fileName.endsWith(".txt")) {
                fileNames.add(fileName.replaceAll(".txt", ""));
            }
        }

        BoardCanvas previewCanvas = new BoardCanvas(new Board(new boolean[20][20]));

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(170, 0));
        leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        leftPanel.setBackground(Constants.COLOR_BACKGROUND_2);

        JLabel descLabel = new JLabel("Selection:");
        descLabel.setForeground(Constants.COLOR_FOREGROUND);
        descLabel.setFont(descLabel.getFont().deriveFont((float) 16));

        fileBox = new MyComboBox<>(fileNames.toArray(new String[0]));
        fileBox.setPreferredSize(new Dimension(150, 35));
        readBoard();
        previewCanvas.setBoard(board);
        fileBox.addActionListener(actionEvent -> {
            if (!fileNames.isEmpty()) {
                readBoard();
                previewCanvas.setBoard(board);
            }
        });

        MyButton submitButton = new MyButton("Submit");
        submitButton.setPreferredSize(new Dimension(150, 35));
        submitButton.addActionListener(e -> {
            mainFrame.setBoard(board);
            this.dispose();
        });

        MyButton cancelButton = new MyButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(150, 35));
        cancelButton.addActionListener(e -> {
            this.dispose();
        });

        leftPanel.add(descLabel);
        leftPanel.add(fileBox);
        leftPanel.add(submitButton);
        leftPanel.add(cancelButton);

        this.add(leftPanel, BorderLayout.WEST);
        this.add(previewCanvas, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public void readBoard() {
        try {
            board = BoardFactory.getFromFile(Utils.getFileByName(fileBox.getItemAt(fileBox.getSelectedIndex()) + ".txt", files));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,  Constants.FILE_READ_ERROR_MESSAGE + e.getMessage(),
                    "Error while loading board file", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }
    }
}
