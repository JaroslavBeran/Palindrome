package palindrome.model.entity;

import palindrome.model.exception.InvalidPalindromeException;
import palindrome.model.type.PalindromeType;


public interface PalindromTypeDetector {

    PalindromeType detectType(String sentence) throws InvalidPalindromeException;

}
