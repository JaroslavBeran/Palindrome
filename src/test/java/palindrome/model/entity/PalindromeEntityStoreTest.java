package palindrome.model.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import palindrome.TestPalindromes;
import palindrome.model.entity.PalindromeEntity;
import palindrome.model.entity.PalindromeEntityFactory;
import palindrome.model.entity.PalindromeEntityStore;
import palindrome.model.exception.AlreadyExistingPalindromeException;
import palindrome.model.exception.InvalidPalindromeException;
import palindrome.model.tool.impl.PalindromeToolProvider;


public class PalindromeEntityStoreTest {

    private PalindromeEntityStore palindromStore;

    private PalindromeToolProvider toolsProvider;
    private PalindromeEntityFactory typeDetector;


    @Before
    public void setUp() throws AlreadyExistingPalindromeException, InvalidPalindromeException {
        toolsProvider = new PalindromeToolProvider();
        typeDetector = new PalindromeEntityFactory(toolsProvider);

        palindromStore = new PalindromeEntityStore(toolsProvider);
        palindromStore.save(typeDetector.createFrom(TestPalindromes.VALID_PALINDROM_1));
        palindromStore.save(typeDetector.createFrom(TestPalindromes.VALID_PALINDROM_2));
        palindromStore.save(typeDetector.createFrom(TestPalindromes.VALID_PALINDROM_3));
    }


    @Test(expected = AlreadyExistingPalindromeException.class)
    public void testSave_Exception() throws AlreadyExistingPalindromeException, InvalidPalindromeException {
        palindromStore.save(typeDetector.createFrom(TestPalindromes.VALID_PALINDROM_1));
    }


    @Test
    public void testSave() throws AlreadyExistingPalindromeException, InvalidPalindromeException {
        palindromStore.save(typeDetector.createFrom(TestPalindromes.VALID_PALINDROM_4));
        assertFalse(palindromStore.getFiltered(TestPalindromes.VALID_PALINDROM_4).isEmpty());
    }


    @Test
    public void testGetFiltered_All() throws InvalidPalindromeException {
        List<PalindromeEntity> filtered = palindromStore.getFiltered(null);

        assertEquals(3, filtered.size());
        assertTrue(filtered.contains(typeDetector.createFrom(TestPalindromes.VALID_PALINDROM_1)));
        assertTrue(filtered.contains(typeDetector.createFrom(TestPalindromes.VALID_PALINDROM_2)));
        assertTrue(filtered.contains(typeDetector.createFrom(TestPalindromes.VALID_PALINDROM_3)));
    }


    @Test
    public void testGetFiltered() throws InvalidPalindromeException {
        List<PalindromeEntity> filtered = palindromStore.getFiltered("ne");
        assertEquals(2, filtered.size());
        assertTrue(filtered.contains(typeDetector.createFrom(TestPalindromes.VALID_PALINDROM_1)));
        assertTrue(filtered.contains(typeDetector.createFrom(TestPalindromes.VALID_PALINDROM_2)));
    }
}
