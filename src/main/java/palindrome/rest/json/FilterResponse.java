package palindrome.rest.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * The response containing filtered palindromes.
 * <p>
 * The available codes:
 * <ul>
 * <li>0 - ok, palindromes were found, or the list is empty,
 * <li>3 - cannot map incoming JSON structure,
 * <li>4 - cannot parse incoming JSON structure,
 * <li>5 - some io error during parsing JSON structure,
 * </ul>
 * 
 * @author Jarda
 *
 */
public class FilterResponse extends AbstracResponse {

    private final List<String> palindromes;


    /**
     * Constructs the response with empty palindrome list.
     */
    private FilterResponse(int code, String message) {
        super(code, message);
        palindromes = new ArrayList<>();
    }


    /**
     * Constructs the response with the list of palindromes.
     * 
     * @param palindromes
     *            the list of found palindromes. MUST NOT be <code>null</code>!
     * 
     */
    private FilterResponse(List<String> palindromes) {
        super(RESPONSE_CODE_OK, RESPONSE_MSG_OK);
        Objects.requireNonNull(palindromes, "Parameter palindromes can not be null!");
        this.palindromes = palindromes;
    }


    /**
     * @return the list containing the filtered palindromes. Can be empty. It is never <code>null</code>.
     */
    public List<String> getPalindromes() {
        return palindromes;
    }


    /**
     * Construct the response structure.
     * 
     * @param palindromes
     *            the list of found palindromes. MUST NOT be <code>null</code>!
     * @return the filter response.
     */
    public static FilterResponse ok(List<String> palindromes) {
        return new FilterResponse(palindromes);
    }


    /**
     * If the input request is not valid JSON {@link FilterRequest} structure.
     * 
     * @return created error response.
     */
    public static FilterResponse cannotMapJSONStructure() {
        return new FilterResponse(RESPONSE_CODE_JSON_CANNOT_MAP_STRUCTURE, RESPONSE_MSG_JSON_CANNOT_MAP_STRUCTURE);
    }


    /**
     * If the input request is not valid JSON {@link FilterRequest} structure.
     * 
     * @return created error response.
     */
    public static FilterResponse cannotParseJSONStructure() {
        return new FilterResponse(RESPONSE_CODE_JSON_CANNOT_PARSE_STRUCTURE, RESPONSE_MSG_JSON_CANNOT_PARSE_STRUCTUE);
    }


    /**
     * If there is any JSON parse exception.
     * 
     * @return created error response.
     */
    public static FilterResponse ioError() {
        return new FilterResponse(RESPONSE_CODE_JSON_IO_ERROR, RESPONSE_MSG_JSON_IO_ERROR);
    }

}
