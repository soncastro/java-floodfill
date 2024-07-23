package com.songomes.floodfillwithjava.controller;

import com.songomes.floodfillwithjava.ui.Pixel;

import java.awt.*;
import java.util.Map;

public interface ScreenController {

    void setAllPixels(Map<Point, Pixel> allPixels);

    void clear();

    boolean isFloodFillEnabled();

    void toggleFloodFillEnabled();

    void drawSquare();

    void performFloodFill(Pixel pixel, Color newColor);

}
