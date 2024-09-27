package GraphicsMode.CustomComponents;

import General.Constants;

import javax.swing.*;
import java.awt.*;

/** Custom Button for dark theme
 *  Source: https://stackoverflow.com/questions/14627223/how-to-change-a-jbutton-color-on-mouse-pressed (modified)
 */
public class MyButton extends JButton {
    private Color pressedColor = Constants.COLOR_PRESSED_BUTTON;
    private Color rolloverColor = Constants.COLOR_HOVER_BUTTON;
    private Color normalColor = Constants.COLOR_BACKGROUND_BUTTON;
    private Color foregroundColor = Constants.COLOR_FOREGROUND;

    public MyButton(ImageIcon icon) {
        super(icon);
        setup();
    }

    public MyButton (String text) {
        super(text);
        setup();
    }

    private void setup() {
        setBorderPainted(false);
        setFocusPainted(false);

        setContentAreaFilled(false);
        setOpaque(true);

        setBackground(normalColor);
        setForeground(foregroundColor);
        setFocusable(false);
        setFontSize(16);

        addChangeListener(evt -> {
            if (getModel().isPressed()) {
                setBackground(pressedColor);
            } else if (getModel().isRollover()) {
                setBackground(rolloverColor);
            } else {
                setBackground(normalColor);
            }
        });
    }

    public void setFontSize(float size) {
        setFont(getFont().deriveFont(size));
    }

    public Color getPressedColor() {
        return pressedColor;
    }

    public void setPressedColor(Color pressedColor) {
        this.pressedColor = pressedColor;
    }

    public Color getRolloverColor() {
        return rolloverColor;
    }

    public void setRolloverColor(Color rolloverColor) {
        this.rolloverColor = rolloverColor;
    }

    public Color getNormalColor() {
        return normalColor;
    }

    public void setNormalColor(Color normalColor) {
        this.normalColor = normalColor;
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
    }
}