package com.github.awwkoala.encryption.cipher;

import com.github.awwkoala.encryption.util.LetterReplacer;
import com.github.awwkoala.encryption.util.StringCharArrayConverter;
import org.apache.commons.lang3.StringUtils;

public class Caesar {
    @Override
    public String toString() {
        return "Caesar Cipher";
    }

    public String encodeCaesar(String stringToEncode) {
        stringToEncode = StringUtils.stripAccents(stringToEncode);
        stringToEncode = stringToEncode.toLowerCase();
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToEncode);
        for (int i=0;i< charArray.length;i++) {
            LetterReplacer replacer = new LetterReplacer();
            char encodedLetter = replacer.replaceLetter(charArray[i],3);
            charArray[i] = encodedLetter;
        }
        String encoded = change.toString(charArray);
        return encoded;
    }
    public String decodeCaesar(String stringToDecode) {
        stringToDecode = StringUtils.stripAccents(stringToDecode);
        stringToDecode = stringToDecode.toLowerCase();
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToDecode);
        for (int i=0;i< charArray.length;i++) {
            LetterReplacer replacer = new LetterReplacer();
            char decodedLetter = replacer.replaceLetter(charArray[i],-3);
            charArray[i] = decodedLetter;
        }
        String decoded = change.toString(charArray);
        return decoded;
    }
}
