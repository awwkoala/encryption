package com.github.awwkoala.encryption.util;

public class StringCharArrayConverter {
    public char[] toCharArray(String string) {
        char[] charArray = string.toCharArray();
        /*char[] charArray = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            charArray[i] = string.charAt(i);
        }*/
        return charArray;
    }
    public String toString(char[] charArray) {
        String string = new String(charArray);
        return string;
    }
}
