package org.howard.edu.lsp.finale.question1;

import java.util.Random;

/**
 * Letters-only algorithm: produces letters only (A–Z, a–z) using {@link java.util.Random}.
 */
public class LettersPasswordAlgorithm implements PasswordAlgorithm {

    private static final String LETTERS =
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
        "abcdefghijklmnopqrstuvwxyz";

    private final Random random = new Random();

    /**
     * Constructs a LettersPasswordAlgorithm.
     */
    public LettersPasswordAlgorithm() { }

    /**
     * {@inheritDoc}
     * 
     * * Generates a password using the currently selected algorithm.
	 *
	 * @param length the desired password length, must be non-negative
	 * @return a generated password string
	 * @throws IllegalStateException if no algorithm has been selected
	 * @throws IllegalArgumentException if length is negative
	 */
    @Override
    public String generate(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("length must be non-negative");
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(LETTERS.charAt(random.nextInt(LETTERS.length())));
        }
        return sb.toString();
    }
}
