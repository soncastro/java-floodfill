package com.songomes.floodfillwithjava.controller;

import com.songomes.floodfillwithjava.ui.Pixel;

import java.awt.*;
import java.util.Map;

public class ScreenControllerImpl implements ScreenController {

    private boolean floodFillEnabled;

    private final int width;

    private final int height;

    private Map<Point, Pixel> allPixels;

    public ScreenControllerImpl(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean isFloodFillEnabled() {
        return floodFillEnabled;
    }

    @Override
    public void toggleFloodFillEnabled() {
        this.floodFillEnabled = !this.floodFillEnabled;
    }

    @Override
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

    @Override
    public void setAllPixels(Map<Point, Pixel> allPixels) {
        if (allPixels == null || allPixels.isEmpty()) throw new IllegalArgumentException();
        this.allPixels = allPixels;
    }

    @Override
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

    @Override
    public void performFloodFill(Pixel pixel, Color newColor) {
        this.validate();
        this.executeFloodFill(pixel, newColor);
    }

    private void executeFloodFill(Pixel pixel, Color newColor) {
        throw new UnsupportedOperationException();
    }

}
