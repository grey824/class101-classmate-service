package net.class101.classmate.util;

import java.util.UUID;

public class IdentifyUtil {

    private static final char SEPARATOR = '-';

    public static String generateUUID(String prefix) {
        return prefix + SEPARATOR + UUID.randomUUID();
    }

}
