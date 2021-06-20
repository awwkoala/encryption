package com.github.awwkoala.encryption.cipher;

import com.github.awwkoala.encryption.util.LetterReplacer;
import com.github.awwkoala.encryption.util.PrepareString;
import com.github.awwkoala.encryption.util.StringCharArrayConverter;

public class ROT13 {
    @Override
    public String toString() {
        return "ROT13 Cipher";
    }

    public String encodeROT13(String stringToEncode) {
        PrepareString prepare = new PrepareString();
        prepare.prepareString(stringToEncode);
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToEncode);
        for (int i = 0; i < charArray.length; i++) {
            LetterReplacer replacer = new LetterReplacer();
            char encodedLetter = replacer.replaceLetter(charArray[i], 13);
            charArray[i] = encodedLetter;
        }
        String encoded = change.toString(charArray);
        return encoded;
    }

    public String decodeROT13(String stringToDecode) {
        PrepareString prepare = new PrepareString();
        prepare.prepareString(stringToDecode);
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToDecode);
        for (int i = 0; i < charArray.length; i++) {
            LetterReplacer replacer = new LetterReplacer();
            char decodedLetter = replacer.replaceLetter(charArray[i], -13);
            charArray[i] = decodedLetter;
        }
        String decoded = change.toString(charArray);
        return decoded;
    }
}
