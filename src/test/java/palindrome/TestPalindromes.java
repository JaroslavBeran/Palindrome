package palindrome;

import palindrome.model.type.PalindromeType;


public final class TestPalindromes {

    private TestPalindromes() {
    }

    public static final String VALID_PALINDROM_1 = "Jelenovi pivo nelej!";
    public static final String VALID_PALINDROM_2 = "Kuna nese nanuk.";
    public static final String VALID_PALINDROM_3 = "Eva, can I see bees in a cave?";
    public static final String VALID_PALINDROM_4 = "Nezařazen.";
    public static final String VALID_PALINDROM_5 = "Sit on a !\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~ potato\npan,\tOtis";
    public static final String VALID_PALINDROM_6 = "+ěščřžýáíé=éíáýžřčšě+";
    public static final String VALID_PALINDROM_7 = "First ladies rule the State and state the rule: ladies first.";
    public static final String VALID_PALINDROM_8 = "Uměle \r vytvořený \n povrch \t vytvořený   uměle.";

    public static final String INVALID_PALINDROM_1 = "Nene\"!`to.neni /P;a'l\\i0ndr43m.";
    public static final String INVALID_PALINDROM_2 = "\u0000" + "Co to je" + "\u001F";

    public enum TestPalindrome {
        PALINDROM1(VALID_PALINDROM_1, PalindromeType.CHARACTER),
        PALINDROM2(VALID_PALINDROM_2, PalindromeType.CHARACTER),
        PALINDROM3(VALID_PALINDROM_3, PalindromeType.CHARACTER),
        PALINDROM4(VALID_PALINDROM_4, PalindromeType.CHARACTER),
        PALINDROM5(VALID_PALINDROM_5, PalindromeType.CHARACTER),
        PALINDROM6(VALID_PALINDROM_6, PalindromeType.CHARACTER),
        PALINDROM7(VALID_PALINDROM_7, PalindromeType.WORD),
        PALINDROM8(VALID_PALINDROM_8, PalindromeType.WORD),;

        private final String palindrome;
        private final PalindromeType palindromeType;


        private TestPalindrome(String palindrome, PalindromeType palindromType) {
            this.palindrome = palindrome;
            this.palindromeType = palindromType;

        }


        /**
         * @return the sequence
         */
        public String getSequence() {
            return palindrome;
        }


        /**
         * @return the type of palindrome
         */
        public PalindromeType getPalindromeType() {
            return palindromeType;
        }
    }
}
