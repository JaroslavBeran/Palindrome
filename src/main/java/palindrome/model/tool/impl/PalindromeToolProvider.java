package palindrome.model.tool.impl;

import java.util.EnumMap;
import java.util.Objects;
import palindrome.model.tool.PalindromeNormalizer;
import palindrome.model.tool.PalindromeValidator;
import palindrome.model.type.PalindromeType;


/**
 * Important tools to normalize, validate the input sentence by required palindrome type {@link PalindromeType}.
 * 
 * @author Jarda
 *
 */
public class PalindromeToolProvider {

    private class ToolPair {
        PalindromeNormalizer normalizer;
        PalindromeValidator validator;


        private ToolPair(PalindromeNormalizer normalizer, PalindromeValidator validator) {
            this.normalizer = normalizer;
            this.validator = validator;
        }

    }

    private final EnumMap<PalindromeType, ToolPair> tools = new EnumMap<>(PalindromeType.class);


    /**
     * Construct the provider.
     */
    public PalindromeToolProvider() {
        tools.put(PalindromeType.CHARACTER,
            new ToolPair(new CharacterPalindromeNormalizer(), new CharacterPalindromeValidator()));
        tools.put(PalindromeType.WORD,
            new ToolPair(new WordPalindromeNormalizer(), new WordPalindromeValidator()));
    }


    /**
     * Normalize the input sequence <code>what</code> by required palindrome type <code>byType</code>.
     * 
     * @param what
     *            input sequence is being normalized. MUST NOT be <code>null</code>.
     * @param byType
     *            to normalize. MUST NOT be <code>null</code>.
     * @return normalized output sequence.
     */
    public String normalize(String what, PalindromeType byType) {
        Objects.requireNonNull(what, "Parameter what must not be null!");
        Objects.requireNonNull(byType, "Parameter byType must not be null!");

        return getNormalizer(byType).normalize(what);
    }


    private PalindromeNormalizer getNormalizer(PalindromeType palindromType) {
        return tools.get(palindromType).normalizer;
    }


    /**
     * Check if the input sequence is valid.
     * 
     * @param what
     *            input sequence is being validate. MUST NOT be <code>null</code>.
     * @param byType
     *            by which type to validate. MUST NOT be <code>null</code>.
     * @return true if the 'what' is valid palindrome, otherwise false.
     */
    public boolean isValid(String what, PalindromeType byType) {
        Objects.requireNonNull(what, "Parameter what must not be null!");
        Objects.requireNonNull(byType, "Parameter byType must not be null!");

        return getValidator(byType).isValid(what);
    }


    private PalindromeValidator getValidator(PalindromeType palindromType) {
        return tools.get(palindromType).validator;
    }

}
