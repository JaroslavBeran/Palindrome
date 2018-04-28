package palindrome.model.tool.impl;

import palindrome.model.tool.PalindromeValidator;


/**
 * Validates word based palindrome.<br/>
 * The word based palindrome must consist of more then 1 word. This type of palindrome must be readable word by word
 * forward and backward.
 * 
 * @author Jarda
 *
 */
public class WordPalindromeValidator implements PalindromeValidator {

    @Override
    public boolean isValid(String toBeChecked) {
        boolean isWordBased = true;
        String[] tokens = toBeChecked.split(PalindromeConstants.SP);

        if (tokens.length < 2) {
            return false; // There must be more then 1 word!
        }

        // Let check the readability
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals(tokens[tokens.length - i - 1])) {
                isWordBased = false;
                break;
            }
        }

        return isWordBased;
    }

}
