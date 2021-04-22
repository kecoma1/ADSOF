package pr4.exceptions;

/**
 * Class to define a invalid component exception.
 * @author Kevin de la Coba and Marcos Bernuy.
 */
public class InvalidComponentException extends Exception {
    
    /**
     * Constructor of the invalid component exception.
     * @param errMsg Error message.
     */
    public InvalidComponentException(String errMsg) {
        super(errMsg);
    }
}
