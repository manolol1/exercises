package GraphicsMode.Frames.NewBoardFrames;

import General.Constants;
import GraphicsMode.CustomComponents.MyButton;
import GraphicsMode.Frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class NewBoardModeSelectionFrame extends JFrame {
    public NewBoardModeSelectionFrame(MainFrame mainFrame) {
        /* set up JFrame */
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(400, 280);
        this.setResizable(false);
        this.setTitle("New Board: Select Mode");
        this.setLocationRelativeTo(mainFrame); // center window on screen
        this.getContentPane().setBackground(Constants.COLOR_BACKGROUND_2);
        this.setLayout(new BorderLayout());

        JLabel infoLabel = new JLabel("Select a board generation mode!", SwingConstants.CENTER);
        infoLabel.setForeground(Constants.COLOR_FOREGROUND);
        infoLabel.setFont(infoLabel.getFont().deriveFont((float) 20));
        infoLabel.setPreferredSize(new Dimension(200, 80));
        this.add(infoLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(Constants.COLOR_BACKGROUND_2);

        MyButton randomButton = new MyButton("Random");
        randomButton.setPreferredSize(new Dimension(150, 40));
        randomButton.addActionListener(e -> {
            this.dispose();
            new NewRandomBoardFrame(mainFrame);
        });

        MyButton fromFileButton = new MyButton("From file");
        fromFileButton.setPreferredSize(new Dimension(150, 40));
        fromFileButton.addActionListener(e -> {
            // Action for fromFileButton
        });

        MyButton cancelButton = new MyButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(150, 40));
        cancelButton.addActionListener(e -> {
            this.dispose();
        });

        buttonPanel.add(randomButton);
        buttonPanel.add(fromFileButton);
        buttonPanel.add(cancelButton);

        this.add(buttonPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
