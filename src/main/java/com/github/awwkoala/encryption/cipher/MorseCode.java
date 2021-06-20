package com.github.awwkoala.encryption.cipher;

import com.github.awwkoala.encryption.util.PrepareString;
import com.github.awwkoala.encryption.util.StringCharArrayConverter;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class MorseCode {
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

    public String encodeMorse(String stringToEncode) {
        PrepareString prepare = new PrepareString();
        prepare.prepareString(stringToEncode);
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToEncode);
        String encoded = "";
        for (int i = 0; i < charArray.length; i++) {
            if (MORSE_CODE.containsKey(charArray[i])) {
                encoded += MORSE_CODE.get(charArray[i]) + "|";
            } else {
                encoded += ""; //if the character doesn't exist as a key in the hashmap, it's ignored in the encoded string
            }
        }
        return encoded;
    }

    public String decodeMorse(String stringToDecode) { //there will be no spaces between words in the decoded string
        BiMap<String, Character> morseCodeInversed = MORSE_CODE.inverse();
        String[] stringArray = stringToDecode.split("\\|");
        String decoded = "";
        for (int i = 0; i < stringArray.length; i++) {
            if (morseCodeInversed.containsKey(stringArray[i])) {
                decoded += morseCodeInversed.get(stringArray[i]);
            } else {
                decoded += "";
            }
        }
        return decoded;
    }
}
