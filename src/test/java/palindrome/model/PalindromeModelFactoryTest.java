package palindrome.model;

import org.junit.Test;


public class PalindromeModelFactoryTest {

    @Test(expected = NullPointerException.class)
    public void testNPException() {
        new PalindromeModelFactory().createBy(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testIAException() {
        new PalindromeModelFactory().createBy("xxx");
    }

}
