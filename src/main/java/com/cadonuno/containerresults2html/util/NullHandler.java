package com.cadonuno.containerresults2html.util;

import java.util.function.Supplier;

public class NullHandler {

    public static <T> T ifNull(T value, Supplier<T> valueIfNull) {
        return value != null
                ? value
                : valueIfNull.get();
    }
}
