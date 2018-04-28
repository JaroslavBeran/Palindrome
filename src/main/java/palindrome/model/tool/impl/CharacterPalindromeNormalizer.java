package palindrome.model.tool.impl;

/**
 * Character palindrome validator removes all unimportant characters as spaces, punctuation.</br>
 * Just applies {@link CommonPalindromeNormalizer#basicNormalizer} and then
 * {@link CommonPalindromeNormalizer#removeSpaces}
 * 
 * @author Jarda
 *
 */
public class CharacterPalindromeNormalizer extends CommonPalindromeNormalizer {

    @Override
    public String normalize(String sequence) {
        return basicNormalizer.andThen(removeSpaces).apply(sequence);
    }

}
