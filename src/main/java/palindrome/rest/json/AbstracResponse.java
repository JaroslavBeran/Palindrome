package palindrome.rest.json;

public class AbstracResponse {

    protected static final int RESPONSE_CODE_OK = 0;
    protected static final int RESPONSE_CODE_INVALID_PALINDROME = 1;
    protected static final int RESPONSE_CODE_PALINDROME_ALREADY_EXISTS = 2;
    protected static final int RESPONSE_CODE_JSON_CANNOT_MAP_STRUCTURE = 3;
    protected static final int RESPONSE_CODE_JSON_CANNOT_PARSE_STRUCTURE = 4;
    protected static final int RESPONSE_CODE_JSON_IO_ERROR = 5;

    protected static final String RESPONSE_MSG_OK = "OK";
    protected static final String RESPONSE_MSG_INVALID_PALINDROME = "Invalid palindrome!";
    protected static final String RESPONSE_MSG_PALINDROME_ALREADY_EXISTS = "Palindrome already exists!";
    protected static final String RESPONSE_MSG_JSON_CANNOT_MAP_STRUCTURE = "Cannot map JSON structure!";
    protected static final String RESPONSE_MSG_JSON_CANNOT_PARSE_STRUCTUE = "Cannot parse JSON structure!";
    protected static final String RESPONSE_MSG_JSON_IO_ERROR = "IO error!";

    private final int code;
    private final String message;


    AbstracResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

}
