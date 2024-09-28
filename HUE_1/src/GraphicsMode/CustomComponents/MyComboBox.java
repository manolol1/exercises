package GraphicsMode.CustomComponents;

import General.Constants;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;

/** JComboBox for dark theme
 *  Source: GitHub Copilot (modified)
 */

public class MyComboBox<E> extends JComboBox<E> {
    public MyComboBox(E[] items) {
        super(items);
        setUI(new DarkComboBoxUI());
        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.PLAIN, 15));
    }

    private static class DarkComboBoxUI extends BasicComboBoxUI {
        @Override
        protected JButton createArrowButton() {
            BasicArrowButton arrowButton = new BasicArrowButton(
                    BasicArrowButton.SOUTH,
                    Constants.COLOR_BACKGROUND_1,
                    Constants.COLOR_BACKGROUND_1,
                    Color.LIGHT_GRAY,
                    Constants.COLOR_BACKGROUND_1
            );
            arrowButton.setBorder(BorderFactory.createEmptyBorder());
            return arrowButton;
        }

        @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
            g.setColor(Constants.COLOR_HOVER_BUTTON);
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }

        @Override
        protected ListCellRenderer<Object> createRenderer() {
            return new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    JLabel renderer = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if (isSelected) {
                        renderer.setBackground(Constants.COLOR_BACKGROUND_1);
                        renderer.setForeground(Color.WHITE);
                    } else {
                        renderer.setBackground(Constants.COLOR_HOVER_BUTTON);
                        renderer.setForeground(Color.WHITE);
                    }
                    return renderer;
                }
            };
        }

        @Override
        protected void installDefaults() {
            super.installDefaults();
            comboBox.setBackground(Constants.COLOR_BACKGROUND_1);
            comboBox.setForeground(Color.WHITE);
            comboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            comboBox.setFocusable(false);
        }

        @Override
        protected ComboPopup createPopup() {
            ComboPopup popup = super.createPopup();
            JComponent popupComponent = (JComponent) popup;
            for (Component component : popupComponent.getComponents()) {
                if (component instanceof JScrollPane) {
                    JScrollPane scrollPane = (JScrollPane) component;
                    JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
                    verticalScrollBar.setUI(new CustomScrollBarUI());
                }
            }
            return popup;
        }
    }

    private static class CustomScrollBarUI extends BasicScrollBarUI {
        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = Constants.COLOR_BACKGROUND_1;
            this.trackColor = Constants.COLOR_BACKGROUND_BUTTON;
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            return button;
        }
    }
}