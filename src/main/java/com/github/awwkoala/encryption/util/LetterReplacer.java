package com.github.awwkoala.encryption.util;
import org.apache.commons.lang3.ArrayUtils;

public class LetterReplacer {
    public char replaceLetter(char letter, int number) {
        char[] alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char replaced;
        if (ArrayUtils.contains(alphabet,letter)) {
            int i = ArrayUtils.indexOf(alphabet,letter);
            replaced = alphabet[((i+number)%alphabet.length+alphabet.length)%alphabet.length];
        }
        else {
            replaced = letter;
        }
        return replaced;
    }
    public int getIndexOfLetter(char letter) {
        char[] alphabet = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        int index = 0;
        if (ArrayUtils.contains(alphabet,letter)) {
            index = ArrayUtils.indexOf(alphabet, letter);
        }
        else {
            index = 0;
        }
        return index;
    }
}
