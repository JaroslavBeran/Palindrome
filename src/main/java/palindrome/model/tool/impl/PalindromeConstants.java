package palindrome.model.tool.impl;

import java.util.regex.Pattern;


final class PalindromeConstants {

    private PalindromeConstants() {
    }

    public static final String SP = " ";
    public static final String EMPTY = "";
    public static final Pattern PUNCT_PATTERN = Pattern.compile("\\p{Punct}");
    public static final Pattern SPACE_PATTERN = Pattern.compile("\\p{Space}");
    public static final Pattern SPACES_PATTERN = Pattern.compile(SP + "{2,}");

}
