package palindrome.model.tool.impl;

import palindrome.model.tool.PalindromValidator;


public class WordPalindromValidator implements PalindromValidator {

    @Override
    public boolean isValid(String toBeChecked) {
        boolean isWordBased = true;
        String[] tokens = toBeChecked.split(PalindromConstants.SP);
        for (int i = 0; i < tokens.length; i++) {
            if (!tokens[i].equals(tokens[tokens.length - i - 1])) {
                isWordBased = false;
                break;
            }
        }
        return isWordBased;
    }

}
