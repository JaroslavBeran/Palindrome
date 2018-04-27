package palindrome.model.tool.impl;

public class WordPalindromeNormalizer extends CommonPalindromeNormalizer {

    @Override
    public String normalize(String sequence) {
        return basicNormalizer.apply(sequence);
    }

}
