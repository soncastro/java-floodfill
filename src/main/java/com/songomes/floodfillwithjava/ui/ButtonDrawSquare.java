package com.songomes.floodfillwithjava.ui;

import javax.swing.*;

public class ButtonDrawSquare extends JButton {

    private final Screen screen;

    public ButtonDrawSquare(String text, Screen screen) {
        super(text);
        this.screen = screen;
    }

    public void draw() {
        this.screen.drawSquare();
    }

}
