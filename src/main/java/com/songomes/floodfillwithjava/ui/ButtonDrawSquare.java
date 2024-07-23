package com.songomes.floodfillwithjava.ui;

import com.songomes.floodfillwithjava.controller.ScreenController;

import javax.swing.*;

public class ButtonDrawSquare extends JButton {

    private final ScreenController screenController;

    public ButtonDrawSquare(String text, ScreenController screenController) {
        super(text);
        this.screenController = screenController;
    }

    public void draw() {
        this.screenController.drawSquare();
    }

}
