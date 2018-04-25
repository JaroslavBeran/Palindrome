package palindrome.model.exception;

public class InvalidPalindromeException extends Exception {

    private static final long serialVersionUID = 2650979786034235614L;


    public InvalidPalindromeException() {
        super();
    }


    public InvalidPalindromeException(String msg) {
        super(msg);
    }
}
