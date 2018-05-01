package palindrome.model.tool.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;


public class WordPalindromeValidatorTest {

    WordPalindromeValidator validator;


    @Before
    public void setUp() {
        validator = new WordPalindromeValidator();
    }


    @Test(expected = NullPointerException.class)
    public void testNull() {
        validator.isValid(null);
    }


    @Test
    public void test() {
        assertTrue(validator.isValid("asd 123 asd"));
        assertFalse(validator.isValid("asd 123 qwe"));
        assertFalse(validator.isValid("asd"));
    }

}
