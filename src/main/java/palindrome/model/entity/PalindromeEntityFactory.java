package palindrome.model.entity;

import java.util.Objects;
import palindrome.model.exception.InvalidPalindromeException;
import palindrome.model.tool.impl.PalindromeToolProvider;
import palindrome.model.type.PalindromeType;


/**
 * Factory creating the palindrome entity class {@link PalindromeEntity}.
 * 
 * @author Jarda
 *
 */
public class PalindromeEntityFactory {

    private final PalindromeToolProvider toolProvider;


    public PalindromeEntityFactory(PalindromeToolProvider toolProvider) {
        Objects.requireNonNull(toolProvider, "Parameter toolProvider cannot be null!");
        this.toolProvider = toolProvider;
    }


    public PalindromeEntity createFrom(String palindrome) throws InvalidPalindromeException {
        Objects.requireNonNull(palindrome, "Parameter palindrome cannot be null!");

        for (PalindromeType type : PalindromeType.values()) {
            String normalizedPalindrome = toolProvider.normalize(palindrome, type);
            if (toolProvider.validate(normalizedPalindrome, type)) {
                return new PalindromeEntity(type, palindrome, normalizedPalindrome);
            }
        }

        throw new InvalidPalindromeException("The palindrome is not a valid: " + palindrome);
    }

}
