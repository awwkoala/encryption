package com.github.awwkoala.encryption.cipher;

import com.github.awwkoala.encryption.util.LetterReplacer;
import com.github.awwkoala.encryption.util.StringCharArrayConverter;
import org.apache.commons.lang3.StringUtils;

public class Vigenere {
    @Override
    public String toString() {
        return "Vigenere Cipher";
    }

    public String encodeVigenere(String stringToEncode, String key) {
        stringToEncode = StringUtils.stripAccents(stringToEncode);
        stringToEncode = stringToEncode.toLowerCase();
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToEncode);
        char[] keyArray = change.toCharArray(key);
        String encoded = "";
        int j = 0;
        for (int i=0;i<charArray.length;i++) {
            char letter = charArray[i];
            if (letter != ' ') {
                char keyLetter = keyArray[j % keyArray.length];
                LetterReplacer getIndexOrReplace = new LetterReplacer();
                int index = getIndexOrReplace.getIndexOfLetter(keyLetter);
                char replaced = getIndexOrReplace.replaceLetter(letter, index);
                encoded += replaced;
                j++;
            }
            else {
                encoded += ' ';
            }
        }
        return encoded;
    }
    public String decodeVigenere(String stringToDecode, String key) {
        stringToDecode = StringUtils.stripAccents(stringToDecode);
        stringToDecode = stringToDecode.toLowerCase();
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToDecode);
        char[] keyArray = change.toCharArray(key);
        String decoded = "";
        int j = 0;
        for (int i = 0; i < charArray.length; i++) {
            char letter = charArray[i];
            if (letter != ' ') {
                char keyLetter = keyArray[j % keyArray.length];
                LetterReplacer getIndexOrReplace = new LetterReplacer();
                int index = -(getIndexOrReplace.getIndexOfLetter(keyLetter));
                char replaced = getIndexOrReplace.replaceLetter(letter, index);
                decoded += replaced;
                j++;
            } else {
                decoded += ' ';
            }
        }
        return decoded;
    }
}
