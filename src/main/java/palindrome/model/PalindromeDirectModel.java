package palindrome.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import palindrome.model.exception.AlreadyExistingPalindromeException;
import palindrome.model.exception.InvalidPalindromeException;
import palindrome.model.tool.impl.PalindromeToolProvider;
import palindrome.model.type.PalindromeType;


class PalindromeDirectModel implements PalindromeModel {

    private final Set<String> palindromes;
    private final PalindromeToolProvider toolProvider;


    public PalindromeDirectModel(PalindromeToolProvider toolProvider) {
        Objects.requireNonNull(toolProvider, "PalindromeToolProvider parameter cannot be null!");

        this.toolProvider = toolProvider;
        palindromes = new HashSet<>();
    }


    /**
     * Normalize and validate. If it is not palindrome the exception is thrown.
     * 
     * @param sequence
     *            to be normalized and validate.
     * @return normalized palindrome sequence
     * @throws InvalidPalindromeException
     */
    private String normalizeAndValidateException(String sequence) throws InvalidPalindromeException {
        String normalizedAndValidated = normalizeAndValidate(sequence);
        if (normalizedAndValidated == null) {
            throw new InvalidPalindromeException("The palindrome '" + sequence + "' is not a palindrome!");
        }
        return normalizedAndValidated;
    }


    /**
     * Normalize and validate the input sequence. If there is no way how to normalize and validate the null is returend.
     * 
     * @param sequence
     *            to be normalized and validated.
     * @return the normalized sequence, or <code>null</code> if it is not possible.
     */
    private String normalizeAndValidate(String sequence) {
        for (PalindromeType palindromeType : PalindromeType.values()) {
            String normalizedPalindrome = toolProvider.normalize(sequence, palindromeType);
            if (toolProvider.isValid(normalizedPalindrome, palindromeType)) {
                return normalizedPalindrome;
            }
        }
        return null;
    }


    @Override
    public void save(String palindrome) throws AlreadyExistingPalindromeException, InvalidPalindromeException {
        Objects.requireNonNull(palindrome, "Parameter palindrome cannot be null!");

        String normalizedPalindrome = normalizeAndValidateException(palindrome);

        // Does the palindrome already exist?
        if (palindromes.stream().anyMatch(p -> normalizeAndValidate(p).equals(normalizedPalindrome))) {
            throw new AlreadyExistingPalindromeException("The palindrome '" + palindrome + "' already exists!");
        }

        palindromes.add(palindrome);
    }


    private Predicate<String> getFilter(String filter) {
        if (filter == null) {
            return p -> true;
        }

        return p -> {
            for (PalindromeType palindromType : PalindromeType.values()) {
                String normalizedPalindrom = toolProvider.normalize(p, palindromType);
                String normalizedFilter = toolProvider.normalize(filter, palindromType);
                if (normalizedPalindrom.contains(normalizedFilter)) {
                    return true;
                }
            }
            return false;
        };
    }


    @Override
    public List<String> getPalindromes(String filter) {
        return palindromes.stream()
            .filter(getFilter(filter))
            .collect(Collectors.toList());
    }

}
