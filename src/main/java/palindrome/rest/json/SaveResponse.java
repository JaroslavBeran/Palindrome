package palindrome.rest.json;

/**
 * Save response - the class is dedicated to convert the response of save request to JSON structure.
 * <p>
 * The response consists of:
 * <ul>
 * <li>code - the result code number describing the result of the operation.
 * <li>message - simple description
 * </ul>
 * 
 * The available codes:
 * <ul>
 * <li>0 - ok, palindrome was added,
 * <li>1 - invalid palindrome,
 * <li>2 - palindrome already exists,
 * <li>3 - cannot map incoming JSON structure,
 * <li>4 - cannot parse incoming JSON structure,
 * <li>5 - some io error during parsing JSON structure,
 * </ul>
 * 
 * @author Jarda
 *
 */
public class SaveResponse extends AbstracResponse {

    private SaveResponse(int code, String message) {
        super(code, message);
    }


    /**
     * OK response. The palindrome was saved.
     * 
     * @return created response.
     */
    public static SaveResponse ok() {
        return new SaveResponse(RESPONSE_CODE_OK, RESPONSE_MSG_OK);
    }


    /**
     * If the incoming sequence is not valid palindrome.
     * 
     * @return created response.
     */
    public static SaveResponse invalidPalindrome() {
        return new SaveResponse(RESPONSE_CODE_INVALID_PALINDROME, RESPONSE_MSG_INVALID_PALINDROME);
    }


    /**
     * Creates the response in case of already existing palindrome.
     * 
     * @return created response.
     */
    public static SaveResponse alreadyExists() {
        return new SaveResponse(RESPONSE_CODE_PALINDROME_ALREADY_EXISTS, RESPONSE_MSG_PALINDROME_ALREADY_EXISTS);
    }


    /**
     * If the input request is not valid JSON {@link SaveRequest} structure.
     * 
     * @return created error response.
     */
    public static SaveResponse cannotMapJSONStructure() {
        return new SaveResponse(RESPONSE_CODE_JSON_CANNOT_MAP_STRUCTURE, RESPONSE_MSG_JSON_CANNOT_MAP_STRUCTURE);
    }


    /**
     * If the input request is not valid JSON {@link SaveRequest} structure.
     * 
     * @return created error response.
     */
    public static SaveResponse cannotParseJSONStructure() {
        return new SaveResponse(RESPONSE_CODE_JSON_CANNOT_PARSE_STRUCTURE, RESPONSE_MSG_JSON_CANNOT_PARSE_STRUCTUE);
    }


    /**
     * If there is any JSON parse exception.
     * 
     * @return created error response.
     */
    public static SaveResponse ioError() {
        return new SaveResponse(RESPONSE_CODE_JSON_IO_ERROR, RESPONSE_MSG_JSON_IO_ERROR);
    }

}
