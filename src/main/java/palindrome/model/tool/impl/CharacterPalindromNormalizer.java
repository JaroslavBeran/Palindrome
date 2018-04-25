package palindrome.model.tool.impl;

public class CharacterPalindromNormalizer extends CommonPalindromNormalizer {

    @Override
    public String normalize(String sequence) {
        return basicNormalizer.andThen(removeSpaces).apply(sequence);
    }

}
