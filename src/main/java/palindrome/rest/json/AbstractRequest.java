package palindrome.rest.json;

/**
 * Incoming request.
 * <p>
 * It is used for both {@link SaveRequest} and {@link FilterRequest}.
 * 
 * @author Jarda
 *
 */
abstract class AbstractRequest {

    private String sequence;


    /**
     * @return the incoming sequence for the request.
     */
    public String getSequence() {
        return sequence;
    }

}
