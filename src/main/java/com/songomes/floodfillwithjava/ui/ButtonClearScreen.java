package com.songomes.floodfillwithjava.ui;

import com.songomes.floodfillwithjava.controller.ScreenController;

import javax.swing.*;

public class ButtonClearScreen extends JButton {

    private final ScreenController screenController;

    public ButtonClearScreen(String text, ScreenController screenController) {
        super(text);
        this.screenController = screenController;
    }

    public void clear() {
        this.screenController.clear();
    }

}
