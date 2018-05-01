package palindrome.model.tool.impl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class WordPalindromeNormalizerTest {

    WordPalindromeNormalizer normalizer;


    @Before
    public void setUp() {
        normalizer = new WordPalindromeNormalizer();
    }


    @Test(expected = NullPointerException.class)
    public void testNull() {
        normalizer.normalize(null);
    }


    @Test
    public void test() {
        assertEquals("abcd escrabcd", normalizer.normalize("  AbCd   ěščřabcd"));
    }
}
