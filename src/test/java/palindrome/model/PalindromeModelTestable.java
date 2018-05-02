package palindrome.model;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import palindrome.TestPalindromes;
import palindrome.TestPalindromes.TestPalindrome;
import palindrome.model.exception.AlreadyExistingPalindromeException;
import palindrome.model.exception.InvalidPalindromeException;


public abstract class PalindromeModelTestable {

    @Rule
    public TestRule benchmarkRun = new BenchmarkRule();

    protected PalindromeModel model;


    @BenchmarkOptions(benchmarkRounds = 1, warmupRounds = 0)
    @Test(expected = InvalidPalindromeException.class)
    public void testSave_Exception() throws InvalidPalindromeException, AlreadyExistingPalindromeException {
        model.save(TestPalindromes.INVALID_PALINDROM_1);
    }


    @BenchmarkOptions(benchmarkRounds = 1, warmupRounds = 0)
    @Test(expected = AlreadyExistingPalindromeException.class)
    public void testSave() throws InvalidPalindromeException, AlreadyExistingPalindromeException {
        model.save(TestPalindromes.VALID_PALINDROM_1);
        model.save(TestPalindromes.VALID_PALINDROM_1);
    }


    @BenchmarkOptions(benchmarkRounds = 10000, warmupRounds = 5)
    @Test
    public void testGetAll() throws InvalidPalindromeException, AlreadyExistingPalindromeException {
        for (TestPalindrome palindrome : TestPalindrome.values()) {
            model.save(palindrome.getSequence());
        }

        assertEquals(TestPalindrome.values().length, model.getPalindromes(null).size());
        assertEquals(TestPalindrome.values().length, model.getPalindromes("").size());

        // Test the palindrome with diacritical
        assertEquals(4, model.getPalindromes("es").size());

        // Test the word based palindrom. The filter contains space.
        assertEquals(1, model.getPalindromes("st l").size());

        // Test the characters based palindrome.
        assertEquals(1, model.getPalindromes("vi pi").size());
    }
}
