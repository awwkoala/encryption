package com.github.awwkoala.encryption.cipher;

import com.github.awwkoala.encryption.util.PrepareString;
import com.github.awwkoala.encryption.util.StringCharArrayConverter;

import java.awt.*;

public class PolybiusSquare implements Cipher {
    @Override
    public String toString() {
        return "Polybius Square";
    }

    private static final char[][] POLYBIUS_SQUARE = new char[][]{{'a', 'b', 'c', 'd', 'e'}, {'f', 'g', 'h', 'i', 'k'},
            {'l', 'm', 'n', 'o', 'p'}, {'q', 'r', 's', 't', 'u'}, {'v', 'w', 'x', 'y', 'z'}};

    @Override
    public String encode(String stringToEncode, String key) {
        PrepareString prepare = new PrepareString();
        stringToEncode = prepare.prepareString(stringToEncode);
        stringToEncode = stringToEncode.replace('j', 'i');
        StringCharArrayConverter change = new StringCharArrayConverter();
        char[] charArray = change.toCharArray(stringToEncode);
        StringBuilder encoded = new StringBuilder();
        for (char c : charArray) {
            Point point = findIndex(c);
            if (point != null) {
                encoded.append(point.x + 1).append(point.y + 1).append(" ");
            } else {
                encoded.append(c);
            }
        }
        return encoded.toString();
    }

    @Override
    public String decode(String stringToDecode, String key) { //Will always decode 24 to 'i', because there's no 'j'
        // in my Polybius square. Also, there won't be spaces between words.
        StringBuilder decoded = new StringBuilder();
        String[] numbersToDecode = stringToDecode.split("\\s+");
        for (String numberToDecode : numbersToDecode) {
            if (numberToDecode.length() == 2 && numberToDecode.charAt(0) <= '5' && numberToDecode.charAt(0) >= '1' &&
                    numberToDecode.charAt(1) <= '5' && numberToDecode.charAt(1) >= '1') {
                char letter = POLYBIUS_SQUARE[Character.getNumericValue(numberToDecode.charAt(0)) - 1]
                        [Character.getNumericValue(numberToDecode.charAt(1)) - 1];
                decoded.append(letter);
            } else {
                decoded.append(numberToDecode);
            }
        }
        return decoded.toString();
    }

    @Override
    public boolean keyRequired() {
        return false;
    }

    private Point findIndex(char searchedChar) {
        for (int iRow = 0; iRow < PolybiusSquare.POLYBIUS_SQUARE.length; iRow++) {
            char[] row = PolybiusSquare.POLYBIUS_SQUARE[iRow];
            for (int iColumn = 0; iColumn < row.length; iColumn++) {
                if (searchedChar == row[iColumn]) {
                    return new Point(iRow, iColumn);
                }
            }
        }
        return null;
    }

}
