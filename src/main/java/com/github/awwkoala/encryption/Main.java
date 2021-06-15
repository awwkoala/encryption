package com.github.awwkoala.encryption;

import com.github.awwkoala.encryption.gui.GraphicalInterface;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        /*LetterReplacer letterReplacer = new LetterReplacer();
        System.out.println(letterReplacer.replaceLetter('a',30));
        ROT13 encodeToROT13 = new ROT13();
        System.out.println(encodeToROT13.encodeROT13("hęęęeello hello łążź HELLO"));
        ROT13 decodeROT13 = new ROT13();
        System.out.println(decodeROT13.decodeROT13("uryyb uryyb URYYB"));
        PolybiusSquare encodeToPolybius = new PolybiusSquare();
        System.out.println(encodeToPolybius.encodePolybius("abcd iii ABC"));
        PolybiusSquare decodeFromPolybius = new PolybiusSquare();
        System.out.println(decodeFromPolybius.decodePolybius("11 12 13 14 24 24 24  24 11"));
        MorseCode encodeToMorse = new MorseCode();
        System.out.println(encodeToMorse.encodeMorse("ab cd"));
        MorseCode decodeFromMorse = new MorseCode();
        System.out.println(decodeFromMorse.decodeMorse("• —|— • • •|— • — •|— • •|"));
        Vigenere encodeVigenere = new Vigenere();
        System.out.println(encodeVigenere.encodeVigenere("To jest bardzo tajny tekst","tajne"));
        System.out.println(encodeVigenere.decodeVigenere("mo srwm bjehso cnngy crolt","tajne"));*/
        JFrame frame = new JFrame("Encryption Program");
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setContentPane(new GraphicalInterface().getMainPanel());
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
