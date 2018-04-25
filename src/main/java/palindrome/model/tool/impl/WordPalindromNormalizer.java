package palindrome.model.tool.impl;

public class WordPalindromNormalizer extends CommonPalindromNormalizer {

    @Override
    public String normalize(String sequence) {
        return basicNormalizer.apply(sequence);
    }

}
