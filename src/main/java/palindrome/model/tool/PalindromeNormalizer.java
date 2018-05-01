package palindrome.model.tool;

/**
 * Normalize the input sequence to output sequence.</br>
 * Remove unimportant characters as punctuation, convert all remaining characters to lower/upper case etc.
 * 
 * @author Jarda
 *
 */
@FunctionalInterface
public interface PalindromeNormalizer {

    /**
     * Just normalize the input sequence. Remove unimportant characters, do lower/upper case etc.
     * 
     * @param sequence
     *            to be normalizes. MUST NOT be <code>null</code>.
     * @return already normalized output sequence.
     */
    String normalize(String sequence);

}
