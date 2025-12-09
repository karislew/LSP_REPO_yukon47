package org.howard.edu.lsp.finale.question1;

import java.util.Random;

/**
 * Basic algorithm: uses {@link java.util.Random} and produces digits only (0-9).
 */
public class BasicPasswordAlgorithm implements PasswordAlgorithm {

    private static final String DIGITS = "0123456789";
    private final Random random = new Random();

    /**
     * Constructs a BasicPasswordAlgorithm.
     */
    public BasicPasswordAlgorithm() { }

    /**
     * {@inheritDoc}
     * <p>
     * 
     * Generates a password consisting of digits only.
     *
     * @param length desired password length, must be non-negative
     * @return a string of digits of the specified length
     * @throws IllegalArgumentException if length is negative
     */
    @Override
    public String generate(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("length must be non-negative");
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        }
        return sb.toString();
    }
}
