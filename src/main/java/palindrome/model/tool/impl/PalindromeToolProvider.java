package palindrome.model.tool.impl;

import java.util.EnumMap;
import palindrome.model.tool.PalindromNormalizer;
import palindrome.model.tool.PalindromValidator;
import palindrome.model.type.PalindromeType;


public class PalindromeToolProvider {

    private class ToolPair {
        PalindromNormalizer normalizer;
        PalindromValidator validator;


        private ToolPair(PalindromNormalizer normalizer, PalindromValidator validator) {
            this.normalizer = normalizer;
            this.validator = validator;
        }

    }

    private EnumMap<PalindromeType, ToolPair> tools = new EnumMap<>(PalindromeType.class);


    public PalindromeToolProvider() {
        tools.put(PalindromeType.CHARACTER,
            new ToolPair(new CharacterPalindromNormalizer(), new CharacterPalindromValidator()));
        tools.put(PalindromeType.WORD,
            new ToolPair(new WordPalindromNormalizer(), new WordPalindromValidator()));
    }


    public String normalize(String what, PalindromeType byType) {
        return getNormalizer(byType).normalize(what);
    }


    private PalindromNormalizer getNormalizer(PalindromeType palindromType) {
        return tools.get(palindromType).normalizer;
    }


    public boolean validate(String what, PalindromeType byType) {
        return getValidator(byType).isValid(what);
    }


    private PalindromValidator getValidator(PalindromeType palindromType) {
        return tools.get(palindromType).validator;
    }

}
