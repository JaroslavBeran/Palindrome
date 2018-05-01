package palindrome.model;

import org.junit.Before;
import palindrome.model.PalindromeModelFactory.PalindromeModelType;


public class PalindromeEntityModelTest extends PalindromeModelTestable {

    @Before
    public void setUp() {
        model = new PalindromeModelFactory().create(PalindromeModelType.ENTITY);
        model = new PalindromeModelFactory().createBy(PalindromeModelType.ENTITY.name());
    }

}
