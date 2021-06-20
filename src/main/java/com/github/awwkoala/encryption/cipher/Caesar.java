package com.github.awwkoala.encryption.cipher;

import com.github.awwkoala.encryption.util.LetterReplacer;
import com.github.awwkoala.encryption.util.PrepareString;
import com.github.awwkoala.encryption.util.StringCharArrayConverter;

public class Caesar implements Cipher {
    @Override
    public String toString() {
        return "Caesar Cipher";
    }

    @Override
    public String encode(String stringToEncode, String key) {
        PrepareString prepare = new PrepareString();
        prepare.prepareString(stringToEncode);
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToEncode);
        for (int i = 0; i < charArray.length; i++) {
            LetterReplacer replacer = new LetterReplacer();
            char encodedLetter = replacer.replaceLetter(charArray[i], 3);
            charArray[i] = encodedLetter;
        }
        String encoded = change.toString(charArray);
        return encoded;
    }

    @Override
    public String decode(String stringToDecode, String key) {
        PrepareString prepare = new PrepareString();
        prepare.prepareString(stringToDecode);
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToDecode);
        for (int i = 0; i < charArray.length; i++) {
            LetterReplacer replacer = new LetterReplacer();
            char decodedLetter = replacer.replaceLetter(charArray[i], -3);
            charArray[i] = decodedLetter;
        }
        String decoded = change.toString(charArray);
        return decoded;
    }
}
