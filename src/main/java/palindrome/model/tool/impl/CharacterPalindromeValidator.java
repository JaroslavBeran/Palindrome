package palindrome.model.tool.impl;

import java.util.Objects;
import palindrome.model.tool.PalindromeValidator;


/**
 * Validator of character based palindrome.<br/>
 * The palindrome must be readable forward and backward character by character.
 * 
 * @author Jarda
 *
 */
public class CharacterPalindromeValidator implements PalindromeValidator {

    @Override
    public boolean isValid(String sequence) {
        Objects.requireNonNull(sequence, "Parameter sequence must not be null!");

        // Create reversed token
        String reverseTmp = new StringBuilder(sequence).reverse().toString();

        // ... are they equal?
        return sequence.equals(reverseTmp);
    }

}
