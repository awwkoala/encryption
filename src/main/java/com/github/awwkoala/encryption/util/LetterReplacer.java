package com.github.awwkoala.encryption.util;

import org.apache.commons.lang3.ArrayUtils;

public class LetterReplacer {
    private static final char[] ALPHABET = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public char replaceLetter(char letter, int number) {
        char replaced;
        if (ArrayUtils.contains(ALPHABET, letter)) {
            int i = ArrayUtils.indexOf(ALPHABET, letter);
            replaced = ALPHABET[((i + number) % ALPHABET.length + ALPHABET.length) % ALPHABET.length];
        } else {
            replaced = letter;
        }
        return replaced;
    }

    public int getIndexOfLetter(char letter) {
        if (ArrayUtils.contains(ALPHABET, letter)) {
            return ArrayUtils.indexOf(ALPHABET, letter);
        } else {
            return 0;
        }
    }
}
