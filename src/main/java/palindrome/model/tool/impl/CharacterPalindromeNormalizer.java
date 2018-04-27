package palindrome.model.tool.impl;

public class CharacterPalindromeNormalizer extends CommonPalindromeNormalizer {

    @Override
    public String normalize(String sequence) {
        return basicNormalizer.andThen(removeSpaces).apply(sequence);
    }

}
