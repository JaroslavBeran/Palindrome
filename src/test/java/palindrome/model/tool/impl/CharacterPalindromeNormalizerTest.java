package palindrome.model.tool.impl;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


public class CharacterPalindromeNormalizerTest {

    CharacterPalindromeNormalizer normalizer;


    @Before
    public void setUp() {
        normalizer = new CharacterPalindromeNormalizer();
    }


    @Test(expected = NullPointerException.class)
    public void testNull() {
        normalizer.normalize(null);
    }


    @Test
    public void testNormalize() {
        assertEquals("priliszlutouckykunupeldabelskeody",
            normalizer.normalize(" Příliš žluťoučký kůň úpěl ďábelské ódy."));
    }

}
