package com.github.awwkoala.encryption.cipher;

import com.github.awwkoala.encryption.util.StringCharArrayConverter;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.apache.commons.lang3.StringUtils;

public class MorseCode {
    @Override
    public String toString() {
        return "Morse Code";
    }

    private BiMap<Character, String> morseCode;
    public MorseCode() {
        morseCode = HashBiMap.create();
        morseCode.put('a', "• —");
        morseCode.put('b', "— • • •");
        morseCode.put('c', "— • — •");
        morseCode.put('d', "— • •");
        morseCode.put('e', "•");
        morseCode.put('f', "• • — •");
        morseCode.put('g', "— — •");
        morseCode.put('h', "• • • •");
        morseCode.put('i', "• •");
        morseCode.put('j', "• — — —");
        morseCode.put('k', "— • —");
        morseCode.put('l', "• — • •");
        morseCode.put('m', "— —");
        morseCode.put('n', "— •");
        morseCode.put('o', "— — —");
        morseCode.put('p', "• — — •");
        morseCode.put('q', "— — • —");
        morseCode.put('r', "• — •");
        morseCode.put('s', "• • •");
        morseCode.put('t', "—");
        morseCode.put('u', "• • —");
        morseCode.put('v', "• • • —");
        morseCode.put('w', "• — —");
        morseCode.put('x', "— • • —");
        morseCode.put('y', "— • — —");
        morseCode.put('z', "— — • •");
    }
    public String encodeMorse(String stringToEncode) {
        stringToEncode = StringUtils.stripAccents(stringToEncode);
        stringToEncode = stringToEncode.toLowerCase();
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToEncode);
        String encoded = "";
        for(int i=0;i<charArray.length;i++) {
            if (morseCode.containsKey(charArray[i])) {
                encoded += morseCode.get(charArray[i])+"|";
            }
            else {
                encoded += ""; //if the character doesn't exist as a key in the hashmap, it's ignored in the encoded string
            }
        }
        return encoded;
    }
    public String decodeMorse(String stringToDecode) { //there will be no spaces between words in the decoded string
        BiMap<String,Character> morseCodeInversed = morseCode.inverse();
        stringToDecode = StringUtils.stripAccents(stringToDecode);
        stringToDecode = stringToDecode.toLowerCase();
        String[] stringArray = stringToDecode.split("\\|");
        String decoded = "";
        for(int i=0;i<stringArray.length;i++) {
            if (morseCodeInversed.containsKey(stringArray[i])) {
                decoded += morseCodeInversed.get(stringArray[i]);
            }
            else {
                decoded += "";
            }
        }
        return decoded;
    }
}
