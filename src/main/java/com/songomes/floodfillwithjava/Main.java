package com.songomes.floodfillwithjava;

import com.songomes.floodfillwithjava.controller.ScreenController;
import com.songomes.floodfillwithjava.controller.ScreenControllerImpl;
import com.songomes.floodfillwithjava.ui.ButtonClearScreen;
import com.songomes.floodfillwithjava.ui.ButtonDrawSquare;
import com.songomes.floodfillwithjava.ui.ButtonFloodFill;
import com.songomes.floodfillwithjava.ui.Pixel;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {

        int width = 40;
        int height = 40;

        ScreenController screenController = new ScreenControllerImpl(width, height);

        JFrame frame = new JFrame("Flood Fill Algorithm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel1 = new JPanel(new GridLayout(1, 1));
        JPanel panel2 = new JPanel(new GridLayout(width, height));
        frame.getContentPane().add(panel1, BorderLayout.NORTH);
        frame.getContentPane().add(panel2, BorderLayout.CENTER);

        Map<Point, Pixel> todosPixels = new HashMap<Point, Pixel>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pixel pixel = new Pixel(x, y, screenController);
                pixel.addActionListener(e -> pixel.performClickPixel(Color.BLACK));
                panel2.add(pixel.getButton());
                todosPixels.put(new Point(x, y), pixel);
            }
        }

        screenController.setAllPixels(todosPixels);

        ButtonFloodFill buttonFloodFill = new ButtonFloodFill(screenController);
        buttonFloodFill.setBackground(Color.WHITE);
        buttonFloodFill.addActionListener(e -> buttonFloodFill.toggleFloodFillEnabled());

        ButtonDrawSquare buttonDrawSquare = new ButtonDrawSquare("Draw Square", screenController);
        buttonDrawSquare.setBackground(Color.WHITE);
        buttonDrawSquare.addActionListener(e -> buttonDrawSquare.draw());

        ButtonClearScreen buttonClearScreen = new ButtonClearScreen("Clear Screen", screenController);
        buttonClearScreen.setBackground(Color.WHITE);
        buttonClearScreen.addActionListener(e -> buttonClearScreen.clear());

        panel1.add(buttonFloodFill);
        panel1.add(buttonDrawSquare);
        panel1.add(buttonClearScreen);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

}
