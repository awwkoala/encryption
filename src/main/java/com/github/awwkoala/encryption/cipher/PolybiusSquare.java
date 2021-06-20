package com.github.awwkoala.encryption.cipher;

import com.github.awwkoala.encryption.util.PrepareString;
import com.github.awwkoala.encryption.util.StringCharArrayConverter;

import java.awt.*;

public class PolybiusSquare implements Cipher {
    @Override
    public String toString() {
        return "Polybius Square";
    }

    char[][] polybiusSquare = new char[][]{{'a', 'b', 'c', 'd', 'e'}, {'f', 'g', 'h', 'i', 'k'}, {'l', 'm', 'n', 'o', 'p'}, {'q', 'r', 's', 't', 'u'}, {'v', 'w', 'x', 'y', 'z'}};

    @Override
    public String encode(String stringToEncode, String key) {
        PrepareString prepare = new PrepareString();
        prepare.prepareString(stringToEncode);
        stringToEncode = stringToEncode.replace('j', 'i');
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToEncode);
        String encoded = "";
        for (int i = 0; i < charArray.length; i++) {
            Point point = findIndex(polybiusSquare, charArray[i]);
            if (point != null) {
                encoded += "" + (point.x + 1) + (point.y + 1) + " ";
            } else {
                encoded += charArray[i];
            }
        }
        return encoded;
    }

    @Override
    public String decode(String stringToDecode, String key) { //Will always decode 24 to 'i', because there's no 'j' in my Polybius square. Also, there won't be spaces between words.
        PrepareString prepare = new PrepareString();
        prepare.prepareString(stringToDecode);
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToDecode);
        String decoded = "";
        String[] numbersToDecode = stringToDecode.split("\\s+");
        for (int i = 0; i < numbersToDecode.length; i++) {
            String numberToDecode = numbersToDecode[i];
            if (numberToDecode.length() == 2 && numberToDecode.charAt(0) <= '5' && numberToDecode.charAt(0) >= '1' && numberToDecode.charAt(1) <= '5' && numberToDecode.charAt(1) >= '1') {
                char letter = polybiusSquare[Character.getNumericValue(numberToDecode.charAt(0)) - 1][Character.getNumericValue(numberToDecode.charAt(1)) - 1];
                decoded += letter;
            } else {
                decoded += numberToDecode;
            }
        }
        return decoded;
    }

    private Point findIndex(char[][] char2DArray, char searchedChar) {
        for (int iRow = 0; iRow < char2DArray.length; iRow++) {
            char[] row = char2DArray[iRow];
            if (row != null) {
                for (int iColumn = 0; iColumn < row.length; iColumn++) {
                    if (searchedChar == row[iColumn]) {
                        return new Point(iRow, iColumn);
                    }
                }
            }
        }
        return null;
    }

}
