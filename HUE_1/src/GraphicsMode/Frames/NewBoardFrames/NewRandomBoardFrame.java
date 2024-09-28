package GraphicsMode.Frames.NewBoardFrames;

import General.BoardFactory;
import General.Constants;
import GraphicsMode.CustomComponents.MyButton;
import GraphicsMode.CustomComponents.MySpinner;
import GraphicsMode.Frames.MainFrame;

import javax.swing.*;
import java.awt.*;

public class NewRandomBoardFrame extends JFrame {
    public NewRandomBoardFrame(MainFrame mainFrame) {
        /* set up JFrame */
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(500, 350);
        this.setResizable(false);
        this.setTitle("New Board: Random");
        this.setLocationRelativeTo(mainFrame); // center window on screen
        this.getContentPane().setBackground(Constants.COLOR_BACKGROUND_2);
        this.setLayout(new BorderLayout());

        // headline
        JLabel infoLabel = new JLabel("Create a new random board!", SwingConstants.CENTER);
        infoLabel.setForeground(Constants.COLOR_FOREGROUND);
        infoLabel.setFont(infoLabel.getFont().deriveFont((float) 20));
        infoLabel.setPreferredSize(new Dimension(200, 80));
        this.add(infoLabel, BorderLayout.NORTH);

        JPanel containerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        containerPanel.setBackground(Constants.COLOR_BACKGROUND_2);

        JPanel gridPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        gridPanel.setBackground(Constants.COLOR_BACKGROUND_2);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(Constants.COLOR_BACKGROUND_2);

        JLabel widthLabel = new JLabel("Board Width (10-600):");
        widthLabel.setForeground(Constants.COLOR_FOREGROUND);
        widthLabel.setFont(widthLabel.getFont().deriveFont((float) 16));
        MySpinner widthSpinner = new MySpinner(150, 10, 600, 1);

        JLabel heightLabel = new JLabel("Board Height: (10-500):");
        heightLabel.setForeground(Constants.COLOR_FOREGROUND);
        heightLabel.setFont(heightLabel.getFont().deriveFont((float) 16));
        MySpinner heightSpinner = new MySpinner(100, 10, 500, 1);

        JLabel probabilityLabel = new JLabel("Alive Probability (0%-100%):");
        probabilityLabel.setForeground(Constants.COLOR_FOREGROUND);
        probabilityLabel.setFont(probabilityLabel.getFont().deriveFont((float) 16));
        MySpinner probabilitySpinner = new MySpinner(20, 1, 100, 1);

        MyButton submitButton = new MyButton("Submit");
        submitButton.setPreferredSize(new Dimension(150, 40));
        submitButton.addActionListener(e -> {
            mainFrame.setBoard(BoardFactory.getRandom((int) heightSpinner.getValue(),
                    (int) widthSpinner.getValue(),
                    (int) probabilitySpinner.getValue()));
            this.dispose();
        });

        MyButton cancelButton = new MyButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(150, 40));
        cancelButton.addActionListener(e -> {
            this.dispose();
        });

        gridPanel.add(widthLabel);
        gridPanel.add(widthSpinner);
        gridPanel.add(heightLabel);
        gridPanel.add(heightSpinner);
        gridPanel.add(probabilityLabel);
        gridPanel.add(probabilitySpinner);

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        containerPanel.add(gridPanel);
        containerPanel.add(buttonPanel);
        this.add(containerPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
