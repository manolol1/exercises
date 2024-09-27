package GraphicsMode.CustomComponents;

import General.Constants;

import javax.swing.*;
import java.awt.*;

public class MySpinner extends JSpinner {
    public MySpinner(int value, int min, int max, int stepSize) {
        super(new SpinnerNumberModel(value, min, max, stepSize));

        setFont(getFont().deriveFont((float) 16));

        // set color of the spinner's up/down buttons (Source: GitHub copilot)
        JComponent editor = getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor) editor;
            spinnerEditor.getTextField().setBackground(Constants.COLOR_BACKGROUND_1);
            spinnerEditor.getTextField().setForeground(Constants.COLOR_FOREGROUND);
        }

        // set color of the spinner's text field (Source: https://stackoverflow.com/questions/22127833/swing-change-the-jspinner-back-and-fore-colors)
        int n = getComponentCount();
        for (int i=0; i<n; i++) {
            Component c = getComponent(i);
            if (c instanceof JButton)
            {
                c.setForeground(Constants.COLOR_FOREGROUND);
                c.setBackground(Constants.COLOR_BACKGROUND_BUTTON);
            }
        }

        // Enforce minimum/maximum values
        addChangeListener(e -> {
            int currentValue = (int) getValue();
            if (currentValue > max) {
                setValue(max);
            } else if (currentValue < min) {
                setValue(min);
            }
        });
    }
}
