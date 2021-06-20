package com.github.awwkoala.encryption.util;

public class StringCharArrayConverter {
    public char[] toCharArray(String string) {
        char[] charArray = string.toCharArray();
        return charArray;
    }
    public String toString(char[] charArray) {
        String string = new String(charArray);
        return string;
    }
}
