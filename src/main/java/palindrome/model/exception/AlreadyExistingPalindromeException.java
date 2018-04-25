package palindrome.model.exception;

public class AlreadyExistingPalindromeException extends Exception {

    private static final long serialVersionUID = -2343396997042931013L;


    public AlreadyExistingPalindromeException() {
        super();
    }


    public AlreadyExistingPalindromeException(String msg) {
        super(msg);
    }

}
