package palindrome.model.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import palindrome.model.type.PalindromeType;


public class PalindromeEntityTest {

    @Rule
    public ExpectedException expectedExcetion = ExpectedException.none();


    @Test
    public void testNull() {
        expectedExcetion.expect(NullPointerException.class);

        new PalindromeEntity(null, null, null);
        new PalindromeEntity(PalindromeType.CHARACTER, null, null);
        new PalindromeEntity(PalindromeType.CHARACTER, "asdf", null);
    }


    @Test
    public void testEquals() {
        PalindromeEntity pe1 = new PalindromeEntity(PalindromeType.CHARACTER, "Asdf", "asdf");
        PalindromeEntity pe2 = new PalindromeEntity(PalindromeType.WORD, "Fdsa zxcv", "fdsa zxcv");
        PalindromeEntity pe3 = new PalindromeEntity(PalindromeType.CHARACTER, "Fdsa", "fdsa");
        PalindromeEntity pe4 = new PalindromeEntity(PalindromeType.CHARACTER, "Asdf", "asdf");

        assertEquals(pe1, pe1); // Same 'pointer'
        assertNotEquals(pe1, null); // Does it equal to 'null'?
        assertNotEquals(pe1, "asdf"); // Does it equal to different type?
        assertNotEquals(pe1, pe2); // Different palindrome type
        assertNotEquals(pe1, pe3); // Different normalized sequence
        assertEquals(pe1, pe4); // Equals
    }


    @Test
    public void testHashCode() {
        PalindromeEntity pe1 = new PalindromeEntity(PalindromeType.CHARACTER, "Asdf", "asdf");
        assertEquals(1817839568, pe1.hashCode());
    }
}
