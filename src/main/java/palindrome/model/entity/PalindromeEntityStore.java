package palindrome.model.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import palindrome.model.exception.AlreadyExistingPalindromeException;
import palindrome.model.tool.impl.PalindromeToolProvider;


public class PalindromeEntityStore {

    private final Set<PalindromeEntity> palindromes;
    private final PalindromeToolProvider toolProvider;


    public PalindromeEntityStore(PalindromeToolProvider toolProvider) {
        Objects.requireNonNull(toolProvider, "Parameter toolProvider parameter cannot be null!");
        this.toolProvider = toolProvider;
        palindromes = new HashSet<>();
    }


    /**
     * Stores the palindrome entity.
     * 
     * @param palindromeEntity
     *            to be stored.
     * @throws AlreadyExistingPalindromeException
     *             if the palindrome is already stored!
     */
    public void save(PalindromeEntity palindromeEntity) throws AlreadyExistingPalindromeException {
        Objects.requireNonNull(palindromeEntity, "Parameter palindromEntity cannot be null!");

        if (palindromes.contains(palindromeEntity)) {
            throw new AlreadyExistingPalindromeException(
                "Palindrome '" + palindromeEntity.getOriginalPalindrome() + "' already exists!");
        }

        palindromes.add(palindromeEntity);
    }


    private Predicate<PalindromeEntity> getFilterPredicate(String filter) {
        if (filter == null) {
            return p -> true;
        }
        return p -> p.getNormalizedPalindrome()
            .contains(toolProvider.normalize(filter, p.getPalindromeType()));
    }


    /**
     * Request for required palindrome(s).
     * 
     * @param filter
     *            substring of required palindrome. If it is <code>null</code> all palindromes are returned.
     * @return list of either all or filtered {@link PalindromeEntity}s. Can be empty list if no
     *         {@link PalindromeEntity} match the filter. <code>null</code> is not ever returned!
     */
    public List<PalindromeEntity> getFiltered(String filter) {
        return palindromes.stream()
            .filter(getFilterPredicate(filter))
            .collect(Collectors.toList());
    }

}
