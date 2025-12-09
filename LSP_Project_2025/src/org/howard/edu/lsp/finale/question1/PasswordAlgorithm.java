package org.howard.edu.lsp.finale.question1;

/**
 * Strategy interface for password generation algorithms.
 * Implementations generate passwords of a requested length.
 */
public interface PasswordAlgorithm {
    /**
     * Generate a password of the given length.
     *
     * @param length the number of characters to generate; must be >= 0
     * @return generated password string of exactly {@code length}
     * @throws IllegalArgumentException if {@code length} is negative
     */
    String generate(int length);
}
