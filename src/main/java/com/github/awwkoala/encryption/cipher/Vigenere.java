package com.github.awwkoala.encryption.cipher;

import com.github.awwkoala.encryption.util.LetterReplacer;
import com.github.awwkoala.encryption.util.PrepareString;
import com.github.awwkoala.encryption.util.StringCharArrayConverter;

public class Vigenere implements Cipher {
    @Override
    public String toString() {
        return "Vigenere Cipher";
    }

    @Override
    public String encode(String stringToEncode, String key) {
        PrepareString prepare = new PrepareString();
        stringToEncode = prepare.prepareString(stringToEncode);
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToEncode);
        char[] keyArray = change.toCharArray(key);
        StringBuilder encoded = new StringBuilder();
        int j = 0;
        for (char letter : charArray) {
            if (letter != ' ') {
                char keyLetter = keyArray[j % keyArray.length];
                LetterReplacer getIndexOrReplace = new LetterReplacer();
                int index = getIndexOrReplace.getIndexOfLetter(keyLetter);
                char replaced = getIndexOrReplace.replaceLetter(letter, index);
                encoded.append(replaced);
                j++;
            } else {
                encoded.append(' ');
            }
        }
        return encoded.toString();
    }

    @Override
    public String decode(String stringToDecode, String key) {
        PrepareString prepare = new PrepareString();
        stringToDecode = prepare.prepareString(stringToDecode);
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToDecode);
        char[] keyArray = change.toCharArray(key);
        StringBuilder decoded = new StringBuilder();
        int j = 0;
        for (char letter : charArray) {
            if (letter != ' ') {
                char keyLetter = keyArray[j % keyArray.length];
                LetterReplacer getIndexOrReplace = new LetterReplacer();
                int index = -(getIndexOrReplace.getIndexOfLetter(keyLetter));
                char replaced = getIndexOrReplace.replaceLetter(letter, index);
                decoded.append(replaced);
                j++;
            } else {
                decoded.append(' ');
            }
        }
        return decoded.toString();
    }
}
