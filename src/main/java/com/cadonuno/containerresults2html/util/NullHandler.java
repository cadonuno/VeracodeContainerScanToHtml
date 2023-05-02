package com.cadonuno.containerresults2html.util;

public class NullHandler {

    public static <T> T ifNull(T value, T valueIfNull) {
        return value != null
                ? value
                : valueIfNull;
    }
}
