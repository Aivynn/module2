package com.util;

import java.util.Random;

public class SimpleNameGenerator {

    public SimpleNameGenerator(){

    }

    private static final Random random = new Random();

    public static String generateName() {
        int start = 97;
        int end = 122;
        int length = random.nextInt(5, 12);
        int i = 0;
        StringBuilder builder = new StringBuilder();

        while (i < length) {
            char letter = (char) random.nextInt(start, end);
            builder.append(letter);
            i++;
        }
        return builder.toString();
    }
}
