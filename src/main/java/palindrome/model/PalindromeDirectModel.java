package palindrome.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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


    @Override
    public void save(String palindrome) throws AlreadyExistingPalindromeException, InvalidPalindromeException {
        Objects.requireNonNull(palindrome, "Palindrome parameter cannot be null!");

        // TODO: complete the functionality!
        if (!palindromes.isEmpty() && palindromes.stream().noneMatch(p -> true)) {
            throw new AlreadyExistingPalindromeException("The palindrome '" + palindrome + "' is not a palindrome!");
        }

        for (PalindromeType palindromeType : PalindromeType.values()) {
            String normalizedPalindrome = toolProvider.normalize(palindrome, palindromeType);
            if (toolProvider.validate(normalizedPalindrome, palindromeType)) {
                palindromes.add(palindrome);
                return;
            }
        }

        throw new InvalidPalindromeException("The palindrome '" + palindrome + "' is not a palindrome!");
    }


    @Override
    public List<String> getPalindromes(String filter) {
        return palindromes.stream()
            .filter(p -> {
                for (PalindromeType palindromType : PalindromeType.values()) {
                    String normalizedPalindrom = toolProvider.normalize(p, palindromType);
                    String normalizedFilter = toolProvider.normalize(p, palindromType);
                    if (normalizedPalindrom.contains(normalizedFilter)) {
                        return true;
                    }
                }
                return false;
            })
            .collect(Collectors.toList());
    }

}
