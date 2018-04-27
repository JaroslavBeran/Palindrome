package palindrome.model.tool.impl;

import palindrome.model.tool.PalindromeValidator;


public class WordPalindromeValidator implements PalindromeValidator {

    @Override
    public boolean isValid(String toBeChecked) {
        boolean isWordBased = true;
        String[] tokens = toBeChecked.split(PalindromeConstants.SP);
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals(tokens[tokens.length - i - 1])) {
                isWordBased = false;
                break;
            }
        }
        return isWordBased;
    }

}
