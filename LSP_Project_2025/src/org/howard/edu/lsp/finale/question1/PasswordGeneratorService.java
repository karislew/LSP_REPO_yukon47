package org.howard.edu.lsp.finale.question1;

 /**
  * Password generation service implemented as a Singleton that uses the
  * Strategy pattern to allow swappable password-generation algorithms.
  *
  * Public API (required):
  *  - public static PasswordGeneratorService getInstance();
  *  - public void setAlgorithm(String name);
  *  - public String generatePassword(int length);
  */

/*
 
 PART C — Required Design Pattern Documentation 
 
 Inside your PasswordGeneratorService class, include a clearly labeled multiline comment block containing:
 
 1. Identify the design pattern(s) you used:

 a. Singleton Pattern is used to ensure that only one instance of PasswordGeneratorService exists, 
 which is required because the assignment specifies a "single shared access point". 

 b The Strategy Pattern is used to allow multiple password-generation approaches to be encapsulated as strategies, 
 enabling the algorithm to be selected at runtime via setAlgorithm(String). Implementations of PasswordAlgorithm 
 (such as BasicPasswordAlgorithm, EnhancedPasswordAlgorithm, and LettersPasswordAlgorithm) 
 encapsulate the behavior and support future expansion without modifying client code.

 2. Explain why these pattern(s) were appropriate for this problem: 
 
 a. These patterns are appropriate because the Singleton satisfies requirement #5 (Provide a single shared access point),
  while the Strategy Pattern satisfies requirements #1–4 by enabling swappable, runtime-selectable, 
  and expandable password-generation behavior without modifying client code.
  
*/

public class PasswordGeneratorService {

    /**
     * Singleton instance of the service.
     */
    private static final PasswordGeneratorService INSTANCE = new PasswordGeneratorService();

    /**
     * Currently selected algorithm strategy. When null, no algorithm is set.
     */
    private PasswordAlgorithm algorithm;

    /**
     * Private constructor to prevent external instantiation.
     */
    private PasswordGeneratorService() { }

    /**
     * Returns the single shared PasswordGeneratorService instance.
     *
     * @return the singleton instance
     */
    public static PasswordGeneratorService getInstance() {
        return INSTANCE;
    }

    /**
     * Selects the algorithm to use. Supported (case-insensitive):
     * basic -  digits only (uses java.util.Random)
     * enhanced -  letters + digits (A–Z, a–z, 0–9) (uses java.security.SecureRandom)
     * letters - letters only (A–Z, a–z)
     *
     * If {@code name} is {@code null}, the current algorithm selection is cleared.
     *
     * @param name the algorithm name to select, or {@code null} to unset
     * @throws IllegalArgumentException if {@code name} is non-null and not supported
     */
    public void setAlgorithm(String name) {
        if (name == null) {
            this.algorithm = null;
            return;
        }
        String key = name.trim().toLowerCase();
        switch (key) {
            case "basic":
                this.algorithm = new BasicPasswordAlgorithm();
                break;
            case "enhanced":
                this.algorithm = new EnhancedPasswordAlgorithm();
                break;
            case "letters":
                this.algorithm = new LettersPasswordAlgorithm();
                break;
            default:
                throw new IllegalArgumentException("Unknown algorithm: " + name);
        }
    }

    /**
     * Generates a password using the currently selected algorithm.
     *
     * @param length desired password length
     * @return generated password string
     * @throws IllegalStateException if no algorithm has been selected
     * @throws IllegalArgumentException if {@code length} is negative
     * @implNote Delegates generation to the selected PasswordAlgorithm strategy.
     */
    public String generatePassword(int length) {
        if (this.algorithm == null) {
            throw new IllegalStateException("No algorithm selected");
        }
        return this.algorithm.generate(length);
    }
}
