package palindrome.model;

import java.util.Objects;
import palindrome.model.tool.impl.PalindromeToolProvider;


/**
 * Factory to create {@link PalindromeModel} implementation.
 * 
 * @author Jarda
 *
 */
public class PalindromeModelFactory {

    private PalindromeToolProvider toolProvider = new PalindromeToolProvider();

    public enum PalindromeModelType {
        /**
         * Using entity structure.
         */
        ENTITY,

        /**
         * Store just the valid palindrome only.
         */
        DIRECT
    };


    /**
     * Creates the model which handles the palindrome save or list methods.
     * 
     * @param type
     *            the model type
     * @return the model
     */
    public PalindromeModel create(PalindromeModelType type) {
        Objects.requireNonNull(type, "Parameter palindrome type cannot be null!");

        if (type == PalindromeModelType.DIRECT) {
            return new PalindromeDirectModel(toolProvider);
        }
        return new PalindromeEntityModel(toolProvider);
    }


    /**
     * Creates the model which handles the palindrome save or list methods.
     * 
     * @param type
     *            use only one of these available values: <code>ENTITY</code> or <code>DIRECT</code>
     * @return the model which handle save, filter requests.
     */
    public PalindromeModel create(String type) {
        return create(PalindromeModelType.valueOf(type));
    }
}
