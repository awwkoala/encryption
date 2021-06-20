package com.github.awwkoala.encryption.cipher;

public interface Cipher {
    String encode(String string, String key);

    String decode(String string, String key);

    boolean keyRequired();
}
