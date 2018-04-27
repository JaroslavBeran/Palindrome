package palindrome.model.tool.impl;

import palindrome.model.tool.PalindromeValidator;


public class CharacterPalindromeValidator implements PalindromeValidator {

    @Override
    public boolean isValid(String sequence) {
        // Create reversed token
        String reverseTmp = new StringBuilder(sequence).reverse().toString();

        // ... are they equal?
        return sequence.equals(reverseTmp);
    }

}
