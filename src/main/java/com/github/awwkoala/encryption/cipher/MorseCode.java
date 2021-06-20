package com.github.awwkoala.encryption.cipher;

import com.github.awwkoala.encryption.util.PrepareString;
import com.github.awwkoala.encryption.util.StringCharArrayConverter;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class MorseCode implements Cipher {
    @Override
    public String toString() {
        return "Morse Code";
    }

    private static final BiMap<Character, String> MORSE_CODE;

    static {
        MORSE_CODE = HashBiMap.create();
        MORSE_CODE.put('a', "• —");
        MORSE_CODE.put('b', "— • • •");
        MORSE_CODE.put('c', "— • — •");
        MORSE_CODE.put('d', "— • •");
        MORSE_CODE.put('e', "•");
        MORSE_CODE.put('f', "• • — •");
        MORSE_CODE.put('g', "— — •");
        MORSE_CODE.put('h', "• • • •");
        MORSE_CODE.put('i', "• •");
        MORSE_CODE.put('j', "• — — —");
        MORSE_CODE.put('k', "— • —");
        MORSE_CODE.put('l', "• — • •");
        MORSE_CODE.put('m', "— —");
        MORSE_CODE.put('n', "— •");
        MORSE_CODE.put('o', "— — —");
        MORSE_CODE.put('p', "• — — •");
        MORSE_CODE.put('q', "— — • —");
        MORSE_CODE.put('r', "• — •");
        MORSE_CODE.put('s', "• • •");
        MORSE_CODE.put('t', "—");
        MORSE_CODE.put('u', "• • —");
        MORSE_CODE.put('v', "• • • —");
        MORSE_CODE.put('w', "• — —");
        MORSE_CODE.put('x', "— • • —");
        MORSE_CODE.put('y', "— • — —");
        MORSE_CODE.put('z', "— — • •");
    }

    @Override
    public String encode(String stringToEncode, String key) {
        PrepareString prepare = new PrepareString();
        stringToEncode = prepare.prepareString(stringToEncode);
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToEncode);
        StringBuilder encoded = new StringBuilder();
        for (char c : charArray) {
            if (MORSE_CODE.containsKey(c)) {
                encoded.append(MORSE_CODE.get(c)).append("|");
            }
        }
        return encoded.toString();
    }

    @Override
    public String decode(String stringToDecode, String key) { //there will be no spaces between words in the decoded string
        BiMap<String, Character> morseCodeInversed = MORSE_CODE.inverse();
        String[] stringArray = stringToDecode.split("\\|");
        StringBuilder decoded = new StringBuilder();
        for (String s : stringArray) {
            if (morseCodeInversed.containsKey(s)) {
                decoded.append(morseCodeInversed.get(s));
            }
        }
        return decoded.toString();
    }

    @Override
    public boolean keyRequired() {
        return false;
    }
}
