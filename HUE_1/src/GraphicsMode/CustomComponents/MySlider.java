package GraphicsMode.CustomComponents;

import General.Constants;

import javax.swing.*;
import javax.swing.plaf.metal.MetalSliderUI;
import java.awt.*;

/** Custom Slider for dark theme
 *  Source: GitHub Copilot (modified)
 */
public class MySlider extends JSlider {
    public MySlider(int min, int max, int value) {
        super(min, max, value);

        setBackground(Constants.COLOR_BACKGROUND_BUTTON);
        setForeground(Constants.COLOR_FOREGROUND);
        setUI(new CustomSliderUI(this));
    }

    private static class CustomSliderUI extends MetalSliderUI {
        public CustomSliderUI(JSlider slider) {
            this.slider = slider;
        }

        @Override
        public void paintTrack(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(Color.DARK_GRAY);
            g2d.fillRect(trackRect.x, trackRect.y, trackRect.width, trackRect.height);
        }

        @Override
        public void paintThumb(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setPaint(Constants.COLOR_PRESSED_BUTTON);
            g2d.fillRect(thumbRect.x, thumbRect.y, thumbRect.width, thumbRect.height);
        }
    }
}