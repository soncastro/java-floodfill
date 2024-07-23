package com.songomes.floodfillwithjava.ui;

import com.songomes.floodfillwithjava.controller.ScreenController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Pixel {

    public final int x;

    public final int y;

    private final ScreenController screenController;

    private final JButton button;

    public Pixel(int x, int y, ScreenController screenController) {
        this.x = x;
        this.y = y;
        this.screenController = screenController;
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
        if (this.screenController.isFloodFillEnabled()) {
            this.screenController.performFloodFill(this, newColor);
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

}
