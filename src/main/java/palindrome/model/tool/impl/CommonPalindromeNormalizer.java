package palindrome.model.tool.impl;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.function.Function;
import palindrome.model.tool.PalindromeNormalizer;


abstract class CommonPalindromeNormalizer implements PalindromeNormalizer {

    /**
     * Diacritical remover.
     */
    protected final Function<String, String> removeDiacritical = str -> Normalizer.normalize(str, Form.NFD)
        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

    /**
     * Replace all punct characters to spaces.
     */
    protected final Function<String, String> replacePunct = str -> PalindromeConstants.PUNCT_PATTERN.matcher(str)
        .replaceAll(PalindromeConstants.SP);

    /**
     * Replace all spaces and tabs to spaces.
     */
    protected final Function<String, String> replaceSpace = str -> PalindromeConstants.SPACE_PATTERN.matcher(str)
        .replaceAll(PalindromeConstants.SP);

    /**
     * Replace sequence of more then one space to one space only.
     */
    protected final Function<String, String> replaceSpaces = str -> PalindromeConstants.SPACES_PATTERN.matcher(str)
        .replaceAll(PalindromeConstants.SP);

    /**
     * To lower case.
     */
    protected final Function<String, String> toLowerCase = str -> str.toLowerCase();

    /**
     */
    protected final Function<String, String> basicNormalizer = replacePunct
        .andThen(removeDiacritical)
        .andThen(replaceSpace)
        .andThen(replaceSpaces)
        .andThen(toLowerCase);

    /**
     * Remove all spaces.
     */
    protected final Function<String, String> removeSpaces = str -> PalindromeConstants.SPACE_PATTERN.matcher(str)
        .replaceAll(PalindromeConstants.EMPTY);

}
