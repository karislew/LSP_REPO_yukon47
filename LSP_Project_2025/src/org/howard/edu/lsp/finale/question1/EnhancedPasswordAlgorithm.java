package org.howard.edu.lsp.finale.question1;

import java.security.SecureRandom;

/**
 * Enhanced algorithm: uses {@link java.security.SecureRandom} and produces
 * alphanumeric characters (A–Z, a–z, 0–9).
 */
public class EnhancedPasswordAlgorithm implements PasswordAlgorithm {

    private static final String ALLOWED =
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
        "abcdefghijklmnopqrstuvwxyz" +
        "0123456789";

    private final SecureRandom secureRandom = new SecureRandom();

    /**
     * Constructs an EnhancedPasswordAlgorithm.
     */
    public EnhancedPasswordAlgorithm() { }

    /**
     * {@inheritDoc}
     * <p>
     * Generates a password consisting of alphanumeric characters (A-Z, a-z, 0-9).
     *
     * @param length desired password length, must be non-negative
     * @return a string of alphanumeric characters of the specified length
     * @throws IllegalArgumentException if length is negative
     */
    @Override
    public String generate(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("length must be non-negative");
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ALLOWED.charAt(secureRandom.nextInt(ALLOWED.length())));
        }
        return sb.toString();
    }
}
