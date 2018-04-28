package palindrome.rest.json;

public class SaveResponse {

    public static final int RESPONSE_CODE_NOT_INITIALIZED = -1;
    public static final int RESPONSE_CODE_OK = 0;
    public static final int RESPONSE_CODE_INVALID_PALINDROME = 1;
    public static final int RESPONSE_CODE_PALINDROME_ALREADY_EXISTS = 2;
    public static final int RESPONSE_CODE_INVALID_INCOMING_JSON_STRUCTURE = 3;
    public static final int RESPONSE_CODE_UNKNOWN_INCOMING_JSON_STRUCTURE = 4;
    public static final int RESPONSE_CODE_IO_ERROR = 5;

    public static final SaveResponse RESPONSE_OK = new SaveResponse(
        "OK", RESPONSE_CODE_OK);

    public static final SaveResponse RESPONSE_INVALID_PALINDROME = new SaveResponse(
        "Invalid palindrome!", RESPONSE_CODE_INVALID_PALINDROME);

    public static final SaveResponse RESPONSE_PALINDROME_ALREADY_EXISTS = new SaveResponse(
        "Palindrome already exists!", RESPONSE_CODE_PALINDROME_ALREADY_EXISTS);

    public static final SaveResponse RESPONSE_INVALID_JSON_STRUCTURE = new SaveResponse(
        "Invalid incoming JSON structure!", RESPONSE_CODE_INVALID_INCOMING_JSON_STRUCTURE);
    public static final SaveResponse RESPONSE_UNKNOWN_JSON_STRUCTURE = new SaveResponse(
        "Unknown incoming JSON structure!", RESPONSE_CODE_UNKNOWN_INCOMING_JSON_STRUCTURE);

    public static final SaveResponse RESPONSE_IO_ERROR = new SaveResponse(
        "IO error!", RESPONSE_CODE_IO_ERROR);

    private final String message;
    private final int code;


    public SaveResponse() {
        message = "";
        code = RESPONSE_CODE_NOT_INITIALIZED;
    }


    private SaveResponse(String result, int responseCode) {
        this.message = result;
        this.code = responseCode;
    }


    public String getMessage() {
        return message;
    }


    public int getCode() {
        return code;
    }
}
