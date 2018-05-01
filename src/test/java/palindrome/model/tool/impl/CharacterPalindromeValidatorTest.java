package palindrome.model.tool.impl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CharacterPalindromeValidatorTest {

    CharacterPalindromeValidator validator = new CharacterPalindromeValidator();


    @Before
    public void setUp() {
        validator = new CharacterPalindromeValidator();
    }


    @Test(expected = NullPointerException.class)
    public void testNull() {
        validator.isValid(null);
    }


    @Test
    public void test() {
        assertTrue(validator.isValid("abcd dcba"));
        assertFalse(validator.isValid("abcd abcd"));
    }

}
