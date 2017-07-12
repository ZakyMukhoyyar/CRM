package com.agit.crm.util;

import java.security.SecureRandom;

/**
 *
 * @author bayutridewanto
 */
public class TestUtil {

    private static final SecureRandom random = new SecureRandom();

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }

    public static int randInt(int min, int max) {
        int randomNum = random.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
