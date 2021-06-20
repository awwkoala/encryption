package com.github.awwkoala.encryption.gui;

import com.github.awwkoala.encryption.cipher.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalInterface {
    private JPanel panel1;
    private JTextField textIn;
    private JComboBox cipherCB;
    private JTextField textOut;
    private JButton encodeButton;
    private JButton decodeButton;
    private JTextField textKey;

    public JPanel getMainPanel() {
        return panel1;
    }

    public GraphicalInterface() {
        cipherCB.addItem(new Caesar());
        cipherCB.addItem(new MorseCode());
        cipherCB.addItem(new PolybiusSquare());
        cipherCB.addItem(new ROT13());
        cipherCB.addItem(new Vigenere());
        textKey.setEnabled(false);
        cipherCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final boolean enabled = cipherCB.getSelectedIndex() == 4;
                textKey.setEnabled(enabled);
            }
        });
        encodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cipherCB.getSelectedIndex() == 0) {
                    Caesar caesar = (Caesar) cipherCB.getItemAt(0);
                    textOut.setText(caesar.encodeCaesar(textIn.getText()));
                }
                if (cipherCB.getSelectedIndex() == 1) {
                    MorseCode morse = (MorseCode) cipherCB.getItemAt(1);
                    textOut.setText(morse.encodeMorse(textIn.getText()));
                }
                if (cipherCB.getSelectedIndex() == 2) {
                    PolybiusSquare polybius = (PolybiusSquare) cipherCB.getItemAt(2);
                    textOut.setText(polybius.encodePolybius(textIn.getText()));
                }
                if (cipherCB.getSelectedIndex() == 3) {
                    ROT13 rot13 = (ROT13) cipherCB.getItemAt(3);
                    textOut.setText(rot13.encodeROT13(textIn.getText()));
                }
                if (cipherCB.getSelectedIndex() == 4) {
                    Vigenere vigenere = (Vigenere) cipherCB.getItemAt(4);
                    textOut.setText(vigenere.encodeVigenere(textIn.getText(), textKey.getText()));
                }
            }
        });
        decodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cipherCB.getSelectedIndex() == 0) {
                    Caesar caesar = (Caesar) cipherCB.getItemAt(0);
                    textOut.setText(caesar.decodeCaesar(textIn.getText()));
                }
                if (cipherCB.getSelectedIndex() == 1) {
                    MorseCode morse = (MorseCode) cipherCB.getItemAt(1);
                    textOut.setText(morse.decodeMorse(textIn.getText()));
                }
                if (cipherCB.getSelectedIndex() == 2) {
                    PolybiusSquare polybius = (PolybiusSquare) cipherCB.getItemAt(2);
                    textOut.setText(polybius.decodePolybius(textIn.getText()));
                }
                if (cipherCB.getSelectedIndex() == 3) {
                    ROT13 rot13 = (ROT13) cipherCB.getItemAt(3);
                    textOut.setText(rot13.decodeROT13(textIn.getText()));
                }
                if (cipherCB.getSelectedIndex() == 4) {
                    Vigenere vigenere = (Vigenere) cipherCB.getItemAt(4);
                    textOut.setText(vigenere.decodeVigenere(textIn.getText(), textKey.getText()));
                }
            }
        });
    }
}
