package pr4.exceptions;

/**
 * Class to define a invalid component exception.
 * @author Kevin de la Coba and Marcos Aarón Bernuy.
 */
public class InvalidComponentException extends Exception {
    
    private String error;

    /**
     * Constructor of the invalid component exception.
     * @param errMsg Error message.
     */
    public InvalidComponentException(String errMsg) {
        super(errMsg);
        this.error = errMsg;
    }

    /**
     * Method to get the error message of the exception.
     * @return Error message of the exception.
     */
    public String getError() {
        return this.error;
    }
}
