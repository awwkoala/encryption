package com.github.awwkoala.encryption.util;

import org.apache.commons.lang3.StringUtils;

public class PrepareString {
    public String prepareString(String string) {
        string = StringUtils.stripAccents(string);
        string = string.toLowerCase();
        return string;
    }
}
