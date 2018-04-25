package palindrome.model.tool;

@FunctionalInterface
public interface PalindromValidator {

    /**
     * Checks if the string is valid palindrome. The sequence must be in normal form. It means the sequence is readable
     * backward as forward without any disturbing characters.
     * 
     * @param normalizedSequence
     *            normalized palindrome string.
     * @return true if it is correct palindrome, otherwise false.
     */
    boolean isValid(String normalizedSequence);

}
