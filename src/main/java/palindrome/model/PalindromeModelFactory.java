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

    private final PalindromeToolProvider toolProvider = new PalindromeToolProvider();

    public enum PalindromeModelType {
        /**
         * Using the entity structure.
         */
        ENTITY,

        /**
         * Store just the valid palindrome.<br/>
         * It always does:
         * <li>the normalization of stored sequence to be able to check if the new sequence is already stored or not.
         * <li>the detection of the type
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
     * Creates the {@link PalindromeModel} model according to string type.
     * 
     * @param type
     *            use only one of these available values: <code>ENTITY</code> or <code>DIRECT</code>.
     * @return the model.
     * @throws IllegalArgumentException
     *             if the type is not the string corresponding to one of these {@link PalindromeModelType}
     * @throws NullPointerException
     *             if the type is <code>null</code>
     */
    public PalindromeModel createBy(String type) {
        return create(PalindromeModelType.valueOf(type));
    }
}
