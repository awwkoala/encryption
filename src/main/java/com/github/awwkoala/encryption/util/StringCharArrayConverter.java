package com.github.awwkoala.encryption.util;

public class StringCharArrayConverter {
    public char[] toCharArray(String string) {
        return string.toCharArray();
    }

    public String toString(char[] charArray) {
        return new String(charArray);
    }
}
