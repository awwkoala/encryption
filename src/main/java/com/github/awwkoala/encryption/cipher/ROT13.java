package com.github.awwkoala.encryption.cipher;

import com.github.awwkoala.encryption.util.LetterReplacer;
import com.github.awwkoala.encryption.util.PrepareString;
import com.github.awwkoala.encryption.util.StringCharArrayConverter;

public class ROT13 implements Cipher {
    @Override
    public String toString() {
        return "ROT13 Cipher";
    }

    @Override
    public String encode(String stringToEncode, String key) {
        PrepareString prepare = new PrepareString();
        stringToEncode = prepare.prepareString(stringToEncode);
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToEncode);
        for (int i = 0; i < charArray.length; i++) {
            LetterReplacer replacer = new LetterReplacer();
            char encodedLetter = replacer.replaceLetter(charArray[i], 13);
            charArray[i] = encodedLetter;
        }
        return change.toString(charArray);
    }

    @Override
    public String decode(String stringToDecode, String key) {
        PrepareString prepare = new PrepareString();
        stringToDecode = prepare.prepareString(stringToDecode);
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToDecode);
        for (int i = 0; i < charArray.length; i++) {
            LetterReplacer replacer = new LetterReplacer();
            char decodedLetter = replacer.replaceLetter(charArray[i], -13);
            charArray[i] = decodedLetter;
        }
        return change.toString(charArray);
    }

    @Override
    public boolean keyRequired() {
        return false;
    }
}
