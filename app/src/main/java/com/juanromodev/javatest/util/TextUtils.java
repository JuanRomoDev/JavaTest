package com.juanromodev.javatest.util;

import java.util.Locale;

public class TextUtils {

    public static String addNumberLines(String text) {
        if (text.isEmpty()) {
            return text;
        }

        StringBuilder builder = new StringBuilder(text);

        int currentIndex = 0;
        for (int i = 1; ; i++) {
            builder.insert(currentIndex, String.format(Locale.US, "%2d. ", i));

            currentIndex = builder.indexOf("\n", currentIndex);

            if (currentIndex == -1) {
                return builder.toString();
            }

            currentIndex++; // Place line number after new line
        }
    }
}
