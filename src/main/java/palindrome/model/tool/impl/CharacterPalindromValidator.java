package palindrome.model.tool.impl;

import palindrome.model.tool.PalindromValidator;


public class CharacterPalindromValidator implements PalindromValidator {

    @Override
    public boolean isValid(String sequence) {
        // Create reversed token
        String reverseTmp = new StringBuilder(sequence).reverse().toString();

        // ... are they equal?
        return sequence.equals(reverseTmp);
    }

}
