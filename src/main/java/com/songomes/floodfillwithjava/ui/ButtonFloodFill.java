package com.songomes.floodfillwithjava.ui;

import com.songomes.floodfillwithjava.controller.ScreenController;

import javax.swing.*;

public class ButtonFloodFill extends JButton {

    private static final String BUTTON_TEXT_DISABLED = "Flood Fill = disabled";
    private static final String BUTTON_TEXT_ENABLED = "Flood Fill = enabled";
    private static final String BUTTON_TEXT_OK = "OK";

    private final ScreenController screenController;

    public ButtonFloodFill(ScreenController screenController) {
        this.screenController = screenController;
        this.updateText();
    }

    public void toggleFloodFillEnabled() {

        this.screenController.toggleFloodFillEnabled();
        this.updateText();

        if (this.screenController.isFloodFillEnabled()) {

            String title = BUTTON_TEXT_ENABLED;
            String msg = "Now, when a pixel is clicked, it will execute the Flood Fill algorithm.";

            JPanel panel = new JPanel();
            JLabel label = new JLabel(msg);
            panel.add(label);
            String[] options = new String[] {BUTTON_TEXT_OK};
            JOptionPane.showOptionDialog(null, panel, title, JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }
        else {

            String title = BUTTON_TEXT_DISABLED;
            String msg = "Now, when a pixel is clicked, it will change to black.";

            JPanel panel = new JPanel();
            JLabel label = new JLabel(msg);
            panel.add(label);
            String[] options = new String[] {BUTTON_TEXT_OK};
            JOptionPane.showOptionDialog(null, panel, title, JOptionPane.NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }

    }

    private void updateText() {
        if (this.screenController.isFloodFillEnabled()) {
            super.setText(BUTTON_TEXT_ENABLED);
        } else {
            super.setText(BUTTON_TEXT_DISABLED);
        }
    }

}
