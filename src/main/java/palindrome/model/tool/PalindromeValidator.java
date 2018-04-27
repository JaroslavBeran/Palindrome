package palindrome.model.tool;

/**
 * Checks if the input sequence is valid palindrome.
 * 
 * @author Jarda
 *
 */
@FunctionalInterface
public interface PalindromeValidator {

    /**
     * Checks if the string is valid palindrome. The sequence must be in normal form. It means the sequence is readable
     * backward as forward without any disturbing characters.
     * 
     * @param sequence
     *            input sequence to be validated. Should be already normalized palindrome string.
     * @return true if it is correct palindrome, otherwise false.
     */
    boolean isValid(String sequence);

}
