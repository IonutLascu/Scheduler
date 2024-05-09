package com.trim.scheduler.utils;

import java.security.SecureRandom;
import java.util.Base64;

public final class CodeGeneratorUtils {

    private static final int BYTE_LENGTH = 12;
    private static final SecureRandom RANDOM = new SecureRandom();

    private CodeGeneratorUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    public static String generateBase64EncodedCode() {
        byte[] randomBytes = new byte[BYTE_LENGTH];
        RANDOM.nextBytes(randomBytes);

        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }
}
