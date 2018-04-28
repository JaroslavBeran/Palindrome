package palindrome.model.tool.impl;

/**
 * Word based palindrome normalizer. Just applies {@link CommonPalindromeNormalizer#basicNormalizer}.
 * 
 * @author Jarda
 *
 */
public class WordPalindromeNormalizer extends CommonPalindromeNormalizer {

    @Override
    public String normalize(String sequence) {
        return basicNormalizer.apply(sequence);
    }

}
