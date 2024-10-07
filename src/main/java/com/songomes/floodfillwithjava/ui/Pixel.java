package com.songomes.floodfillwithjava.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Pixel {

    public final int x;

    public final int y;

    private final Screen screen;

    private final JButton button;

    public Pixel(int x, int y, Screen screen) {
        this.x = x;
        this.y = y;
        this.screen = screen;
        this.button = new JButton();
        this.changeColor(Color.WHITE);
    }

    public JButton getButton() {
        return this.button;
    }

    public Color getColor() {
        return this.button.getBackground();
    }

    public void addActionListener(ActionListener actionListener) {
        this.button.addActionListener(actionListener);
    }

    public void performClickPixel(Color newColor) {
        if (this.screen.isFloodFillEnabled()) {
            this.screen.performFloodFill(this, newColor);
        } else {
            if (this.button.getBackground().equals(Color.BLACK)) {
                this.button.setBackground(Color.WHITE);
            } else {
                this.button.setBackground(Color.BLACK);
            }
        }
    }

    public void changeColor(Color newColor) {
        this.button.setBackground(newColor);
    }

    public void repaint() {
        this.button.repaint();
    }

}
