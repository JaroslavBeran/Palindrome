package palindrome.model.tool.impl;

import java.util.function.Function;
import palindrome.model.tool.PalindromNormalizer;


abstract class CommonPalindromNormalizer implements PalindromNormalizer {

    /**
     * Replace all punct characters to spaces.
     */
    protected Function<String, String> replacePunct = str -> PalindromConstants.PUNCT_PATTERN.matcher(str)
        .replaceAll(PalindromConstants.SP);

    /**
     * Replace all spaces and tabs to spaces.
     */
    protected Function<String, String> replaceSpace = str -> PalindromConstants.SPACE_PATTERN.matcher(str)
        .replaceAll(PalindromConstants.SP);

    /**
     * Replace sequence of more then one space to one space only.
     */
    protected Function<String, String> replaceSpaces = str -> PalindromConstants.SPACES_PATTERN.matcher(str)
        .replaceAll(PalindromConstants.SP);

    /**
     * To lower case.
     */
    protected Function<String, String> toLowerCase = str -> str.toLowerCase();

    /**
     * Basic normalizer for both word and character based palindroms.
     */
    protected Function<String, String> basicNormalizer = replacePunct
        .andThen(replaceSpace)
        .andThen(replaceSpaces)
        .andThen(toLowerCase);

    /**
     * Remove all spaces.
     */
    protected Function<String, String> removeSpaces = str -> PalindromConstants.SPACE_PATTERN.matcher(str)
        .replaceAll(PalindromConstants.EMPTY);

}
