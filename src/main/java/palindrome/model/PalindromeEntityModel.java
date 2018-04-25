package palindrome.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import palindrome.model.entity.PalindromeEntity;
import palindrome.model.entity.PalindromeEntityFactory;
import palindrome.model.entity.PalindromeEntityStore;
import palindrome.model.exception.AlreadyExistingPalindromeException;
import palindrome.model.exception.InvalidPalindromeException;
import palindrome.model.tool.impl.PalindromeToolProvider;


class PalindromeEntityModel implements PalindromeModel {

    private final PalindromeEntityStore palindromeStore;
    private final PalindromeEntityFactory palindromeEntityFactory;


    public PalindromeEntityModel(PalindromeToolProvider toolProvider) {
        palindromeStore = new PalindromeEntityStore(toolProvider);
        palindromeEntityFactory = new PalindromeEntityFactory(toolProvider);
    }


    @Override
    public void save(String palindrome) throws AlreadyExistingPalindromeException, InvalidPalindromeException {
        Objects.requireNonNull(palindrome, "Parameter palindrome cannot be null!");

        // Try to detect palindrome's type.
        // If it is not a palindrome throws the InvalidPalindromException
        PalindromeEntity palindromEntity = palindromeEntityFactory.createFrom(palindrome);

        palindromeStore.save(palindromEntity);
    }


    @Override
    public List<String> getPalindromes(String filter) {
        return palindromeStore.getFiltered(filter).stream()
            .map(pe -> pe.getOriginalPalindrome())
            .collect(Collectors.toList());
    }

}
