package com.github.awwkoala.encryption;

import com.github.awwkoala.encryption.gui.GraphicalInterface;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Encryption Program");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setContentPane(new GraphicalInterface().getMainPanel());
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
