package palindrome.model;

import org.junit.Before;
import palindrome.model.PalindromeModelFactory.PalindromeModelType;


public class PalindromeDirectModelTest extends PalindromeModelTestable {

    @Before
    public void setUp() {
        model = new PalindromeModelFactory().create(PalindromeModelType.DIRECT);
        model = new PalindromeModelFactory().createBy(PalindromeModelType.DIRECT.name());
    }

}
