package com.songomes.floodfillwithjava.ui;

import javax.swing.*;

public class ButtonClearScreen extends JButton {

    private final Screen screen;

    public ButtonClearScreen(String text, Screen screen) {
        super(text);
        this.screen = screen;
    }

    public void clear() {
        this.screen.clear();
    }

}
