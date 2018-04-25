package palindrome.model.entity;

import palindrome.model.type.PalindromeType;


/**
 * This class contains valid palindrome details as:
 * <ul>
 * <li>palindrome type - word or character based {@link PalindromeType}
 * <li>original palindrome string sequence
 * <li>normalized palindrome sequence - it depends on the type
 * </ul>
 * <p>
 * Class defines its {@link #hashCode()}, {@link #equals(Object)} functions where the type and normalized string
 * sequence are used.
 * 
 * @author Jarda
 *
 */
public class PalindromeEntity {

    private final PalindromeType palindromeType;
    private final String normalizedPalindrome;
    private final String originalPalindrome;


    /**
     * Constructor.
     * 
     * @param palindromeType
     *            is type of the palindrome.
     * @param originalPalindrome
     *            is original palindrome string sequence.
     * @param normalizedPalindrome
     *            is normalized palindrome string sequence according to the type.
     */
    public PalindromeEntity(PalindromeType palindromeType,
                            String originalPalindrome,
                            String normalizedPalindrome) {
        this.palindromeType = palindromeType;
        this.normalizedPalindrome = normalizedPalindrome;
        this.originalPalindrome = originalPalindrome;
    }


    /**
     * @return the type of the palindrome.
     */
    public PalindromeType getPalindromeType() {
        return palindromeType;
    }


    /**
     * @return the normalized string sequence of the palindrome.
     */
    public String getNormalizedPalindrome() {
        return normalizedPalindrome;
    }


    /**
     * @return the original string sequence of the palindrome.
     */
    public String getOriginalPalindrome() {
        return originalPalindrome;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((normalizedPalindrome == null) ? 0 : normalizedPalindrome.hashCode());
        result = prime * result + ((palindromeType == null) ? 0 : palindromeType.hashCode());
        return result;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PalindromeEntity other = (PalindromeEntity) obj;
        if (palindromeType != other.palindromeType) {
            return false;
        }
        if (normalizedPalindrome == null) {
            if (other.normalizedPalindrome != null) {
                return false;
            }
        } else if (!normalizedPalindrome.equals(other.normalizedPalindrome)) {
            return false;
        }
        return true;
    }

}
