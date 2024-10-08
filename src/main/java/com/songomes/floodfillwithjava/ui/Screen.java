package com.songomes.floodfillwithjava.ui;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Screen {

    private boolean floodFillEnabled;

    private final int width;

    private final int height;

    private Map<Point, Pixel> allPixels;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean isFloodFillEnabled() {
        return floodFillEnabled;
    }

    public void toggleFloodFillEnabled() {
        this.floodFillEnabled = !this.floodFillEnabled;
    }

    public void drawSquare() {
        this.validate();

        int x_value_min = 6;
        int x_value_max = 34;

        int y_value_min = 6;
        int y_value_max = 34;

        if (x_value_max >= this.width || y_value_max >= this.height) {
            throw new IllegalStateException();
        }

        for (int y = y_value_min; y <= y_value_max; y++) {

            this.allPixels.get(new Point(x_value_min, y)).changeColor(Color.BLACK);
            this.allPixels.get(new Point(x_value_max, y)).changeColor(Color.BLACK);

            if (y == y_value_min || y == y_value_max) {
                for (int x = x_value_min; x <= x_value_max; x++) {
                    this.allPixels.get(new Point(x, y)).changeColor(Color.BLACK);
                }
            }
        }
    }

    public void setAllPixels(Map<Point, Pixel> allPixels) {
        if (allPixels == null || allPixels.isEmpty()) throw new IllegalArgumentException();
        this.allPixels = allPixels;
    }

    public void clear() {
        this.validate();
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                this.allPixels.get(new Point(x, y)).changeColor(Color.WHITE);
            }
        }
    }

    private void validate() {
        if (this.allPixels == null || this.allPixels.isEmpty()) {
            throw new IllegalStateException();
        }
    }

    public void performFloodFill(Pixel pixel, Color newColor) {
        this.validate();
        this.executeFloodFill(pixel, newColor);
    }

    private void executeFloodFill(Pixel pixel, Color newColor) {

        // TODO: Delete the lines below after implementing this method
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Flood Fill has not been implemented.");
        panel.add(label);
        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, panel, "Flood Fill Not Implemented", JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
    }

    private boolean isValid(Pixel pixel, Color newColor) {
        if ((pixel != null) && (pixel.x < this.width) && (pixel.y < this.height) //
                && !pixel.getColor().equals(newColor)) {
            return true;
        }
        return false;
    }

}
