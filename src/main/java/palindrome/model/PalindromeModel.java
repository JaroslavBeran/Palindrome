package palindrome.model;

import java.util.List;
import palindrome.model.exception.AlreadyExistingPalindromeException;
import palindrome.model.exception.InvalidPalindromeException;


/**
 * Palindrome model which handles adding of new palindrome and listing/filtering of already saved palindrome.
 * 
 * @author Jarda
 *
 */
public interface PalindromeModel {

    /**
     * Requests to save new <code>palindrome</code>. Method checks if the palindrome is valid and checks if it is
     * already saved.
     * <p>
     * Two palindromes are equal if their normalized sequence are equal.</br>
     * See the example:
     * <ol>
     * <table border="1" cellpadding="3" cellspacing="1" frame="all">
     * <tr>
     * <th>Type of the palindrome
     * <th>Valid palindrome sequences
     * <th>Valid and normalized palindrome sequences
     * </tr>
     * <tr>
     * <td>character
     * <td><code>Able was I, ere I saw Elba.</code>
     * <td><code>ablewasiereisawelba</code>
     * </tr>
     * <tr>
     * <td>character
     * <td><code>ablE was I, ERE I saw Elba .</code>
     * <td><code>ablewasiereisawelba</code>
     * </tr>
     * <tr>
     * <td>word
     * <td><code>Herb the sage eats sage, the herb.</code>
     * <td><code>herb the sage eats sage the herb</code>
     * </tr>
     * <tr>
     * <td>word
     * <td><code>Herb  THE :sage: eats sage, the Herb.</code>
     * <td><code>herb the sage eats sage the herb</code>
     * </tr>
     * </table>
     * </ol>
     * 
     * @param palindrome
     *            to be stored. MUST NOT be <code>null</code>, otherwise the {@link NullPointerException} is thrown.
     * @throws InvalidPalindromeException
     *             if the palindrome is not valid palindrome.
     * @throws AlreadyExistingPalindromeException
     *             if the palindrome is already saved.
     */
    void save(String palindrome) throws InvalidPalindromeException, AlreadyExistingPalindromeException;


    /**
     * Gets the list of all saved palindromes or filtered only. The string sequence of each palindrome is not modified.
     * 
     * @param filter
     *            substring filter
     * @return the list of valid palindromes
     */
    List<String> getPalindromes(String filter);

}
